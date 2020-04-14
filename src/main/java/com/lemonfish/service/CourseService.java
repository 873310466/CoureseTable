package com.lemonfish.service;

import com.lemonfish.pojo.entity.Course;
import com.lemonfish.util.MyJsonResult;
import org.springframework.web.bind.annotation.PathVariable;

/**
* 相关Service
* @author Lemonfish
* @version 1.0
* @date 2020-03-24
 * Copyright © Chao Zhang
*/
public interface CourseService extends BaseCustomService<Course> {
    MyJsonResult getWeekList(long week);
}
