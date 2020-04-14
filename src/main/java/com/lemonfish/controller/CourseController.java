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
        return courseService.getWeekList(week);
    }

}
