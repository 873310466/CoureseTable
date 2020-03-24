package com.lemonfish.service.impl;

import com.diboot.core.service.impl.BaseServiceImpl;
import com.lemonfish.pojo.entity.Course;
import com.lemonfish.mapper.CourseMapper;
import com.lemonfish.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* 相关Service实现
* @author Lemonfish
* @version 1.0
* @date 2020-03-24
 * Copyright © Chao Zhang
*/
@Service
@Slf4j
public class CourseServiceImpl extends BaseCustomServiceImpl<CourseMapper, Course> implements CourseService {
    public CourseServiceImpl() {
    }
}
