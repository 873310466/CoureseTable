package com.lemonfish.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chao Zhang
 * @version V1.0
 * @Package com.lemonfish.pojo.entity
 * @date 2020/3/24 19:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRow {
    List<Course> courses = new ArrayList<>();
}
