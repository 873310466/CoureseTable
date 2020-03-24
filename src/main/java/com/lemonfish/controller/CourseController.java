package com.lemonfish.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lemonfish.enumcode.CodeEnum;
import com.lemonfish.util.MyJsonResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lemonfish.pojo.entity.Course;
import com.lemonfish.service.CourseService;
import com.lemonfish.pojo.vo.CourseVO;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 相关Controller
 *
 * @author Lemonfish
 * @version 1.0
 * @date 2020-03-24
 * Copyright © Chao Zhang
 */
@RestController
@RequestMapping("/course")
@Slf4j
public class CourseController extends BaseCrudMappingRestController<Course, CourseVO> {
    @Autowired
    private CourseService courseService;


    @GetMapping("/{week}")
    public MyJsonResult getPerWeekData(long week) {
        List<List<Course>> res = new ArrayList<>();

        LambdaQueryWrapper<Course> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Course::getWeek, week);
        List<Course> entityList = courseService.getEntityList(lqw);
        for (long i = 1; i < 13; i++) {
            long day = i;
            List<Course> coursesPerDay = entityList.stream().filter(item -> item.getBegin() == day).collect(Collectors.toList());
            if (coursesPerDay.size() > 0) {
                coursesPerDay.forEach(System.out::println);
                res.add(coursesPerDay);
            }
        }
        return res.size() > 0 ? MyJsonResult.success(res) : MyJsonResult.fail(CodeEnum.FAIL_NOT_FOUND);
    }

    @GetMapping("/data")
    public String crawlingData() throws InterruptedException {
        // 设置webdriver路径
        System.setProperty("webdriver.chrome.driver", CourseController.class.getClassLoader().getResource("chromedriver.exe").getPath());
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://pass.neu.edu.cn/tpass/login?service=http%3A%2F%2F219.216.96.4%2Feams%2FhomeExt.action");

        webDriver.findElement(By.id("un")).sendKeys("20180824");
        webDriver.findElement(By.id("pd")).sendKeys("123456as");
        Thread.sleep(1000);

        WebElement loginBtn = webDriver.findElement(By.className("login_box_landing_btn"));
        loginBtn.click();

        Thread.sleep(1000);

        webDriver.findElement(By.xpath("//*[@id=\"menu_panel\"]/ul/li[1]/ul/div/li[13]/a")).click();

        Thread.sleep(1000);
        // 选择第几周的下拉框
        WebElement select = webDriver.findElement(By.id("startWeek"));
        Select weekList = new Select(select);

        // 从1到17周
        for (long i = 1; i < 18; i++) {
            System.out.println("第----------------" + i + "周----------------");
            Thread.sleep(1000);
            // 选择第 i 周
            weekList.selectByValue(i + "");
            Thread.sleep(1000);

            for (long j = 1; j < 13; j++) {
                if (j % 2 == 1) {
                    WebElement row = webDriver.findElement(By.xpath("//*[@id=\"manualArrangeCourseTable\"]/tbody/tr[" + j + "]"));
                    List<WebElement> tds = row.findElements(By.tagName("td"));
                    if (tds.size() > 0) {
                        System.out.println("第" + j + "节--" + (j + 1) + "节");
                        System.out.println("size:" + tds.size());
                        for (int k = 0; k < tds.size(); k++) {
                            long day = getDay(k);

                            String title = tds.get(k).getAttribute("title");
                            String rowspan = tds.get(k).getAttribute("rowspan");

                            if (title != null && !"".equals(title)) {
                                if (day != 0) {
                                    System.out.println("星期" + day);
                                }
                                String[] titleSplit = title.split(" ");
                                String[] firstSplit = titleSplit[0].split("\\(");
                                String name = firstSplit[0];
                                String[] secondSplit = titleSplit[1].split(";;;");
                                String teacher = clearBothBrackets(secondSplit[0]);
                                String[] locationSplit = secondSplit[1].split(",");

                                String location = locationSplit.length == 1 ? "风雨操场" : clearBothBrackets(locationSplit[1], 1);
                                Course course = new Course();
                                course.setName(name);
                                course.setTeacher(teacher);
                                course.setWeek(i);
                                course.setDay(day);
                                course.setBegin(j);
                                course.setLocation(location);
                                course.setRowSpan(Long.parseLong(rowspan));
                                boolean flag = courseService.createEntity(course);
                                if (flag) {
                                    System.out.println("添加成功");
                                }

                                System.out.println("name:" + name);
                                System.out.println("teacher:" + teacher);
                                System.out.println("location:" + location);
                                System.out.println("week" + i);
                                System.out.println("day" + day);
                                System.out.println("rowSpan" + rowspan);

                            }
                        }
                        System.out.println("---------我是分割线---------");
                    }
                }
            }
        }
        return null;
    }

    // 获取星期数
    public static int getDay(int i) {
        switch (i) {
            case 1:
                return 7;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            default:
                return 0;
        }
    }


    // 去除字符串两边的括号
    public static String clearBothBrackets(String target) {
        return clearBothBrackets(target, 0);
    }

    // 去除括号 -1 表示去除左边括号，1 表示去除右边括号，其他情况表示去除两边括号
    public static String clearBothBrackets(String target, int location) {
        switch (location) {
            case -1:
                return target.substring(1, target.length());
            case 1:
                return target.substring(0, target.length() - 1);
            default:
                return target.substring(1, target.length() - 1);
        }
    }

}
