package com.lemonfish;
import	java.util.ArrayList;
import	java.util.LinkedList;
import	java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lemonfish.pojo.entity.Course;
import com.lemonfish.pojo.entity.CourseRow;
import com.lemonfish.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    CourseService courseService;


    @Test
    void contextLoads() {
        List<List<Course>> res = new ArrayList<>();

        LambdaQueryWrapper<Course> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Course::getWeek, 1);
        List<Course> entityList = courseService.getEntityList(lqw);
        for (long i = 1; i < 13; i++) {
            long day = i;
            List<Course> coursesPerDay = entityList.stream().filter(item -> item.getBegin() == day).collect(Collectors.toList());
            if (coursesPerDay.size()>0) {
                coursesPerDay.forEach(System.out::println);
                res.add(coursesPerDay);
                System.out.println("-------------------");
            }
        }

        System.out.println(res.size());
    }
}
