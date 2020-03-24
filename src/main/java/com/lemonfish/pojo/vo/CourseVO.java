package com.lemonfish.pojo.vo;

import com.diboot.core.binding.annotation.*;
import com.lemonfish.pojo.entity.Course;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
*  VO定义
* @author Lemonfish
* @version 1.0
* @date 2020-03-24
 * Copyright © Chao Zhang
*/
@Getter @Setter @Accessors(chain = true)
public class CourseVO extends Course  {
    private static final long serialVersionUID = -8121810063360620330L;

}