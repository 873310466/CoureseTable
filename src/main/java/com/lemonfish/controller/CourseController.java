package com.lemonfish.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lemonfish.enumcode.CodeEnum;
import com.lemonfish.pojo.entity.Course;
import com.lemonfish.service.CourseService;
import com.lemonfish.util.MyJsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/table/{week}")
    public MyJsonResult getPerWeekData(@PathVariable("week") long week) {
        // 课程表是一个二维的
        List<List<Course>> res = new ArrayList<>();

        LambdaQueryWrapper<Course> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Course::getWeek, week);
        // 获取周数为`week`的课程数据
        List<Course> entityList = courseService.getEntityList(lqw);

        for (long i = 1; i < 13; i++) {
            long begin = i;
            List<Course> coursesPerDay = entityList.stream().filter(item -> item.getBegin() == begin).collect(Collectors.toList());
            coursesPerDay.forEach(System.out::println);
            res.add(coursesPerDay);
        }
        return res.size() > 0 ? MyJsonResult.success(res) : MyJsonResult.fail(CodeEnum.FAIL_NOT_FOUND);
    }


}
