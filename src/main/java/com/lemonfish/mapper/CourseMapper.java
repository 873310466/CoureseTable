package com.lemonfish.mapper;

import com.diboot.core.mapper.BaseCrudMapper;
import com.lemonfish.pojo.entity.Course;
import org.apache.ibatis.annotations.Mapper;

/**
* Mapper
* @author Lemonfish
* @version 1.0
* @date 2020-03-24
 * Copyright © Chao Zhang
*/
@Mapper
public interface CourseMapper extends BaseCrudMapper<Course> {

}

