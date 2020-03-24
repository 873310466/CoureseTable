package com.lemonfish.pojo.entity;

import java.util.Date;
import javax.validation.constraints.NotNull;

import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.diboot.core.entity.BaseEntity;
import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
*  Entity定义
* @author Lemonfish
* @version 1.0
* @date 2020-03-24
* Copyright © Chao Zhang
*/
@Getter @Setter @Accessors(chain = true)
@ToString
public class Course extends BaseCustomEntity {
    private static final long serialVersionUID = -2844258969355517987L;


    // 课程名称
    @NotNull(message = "课程名称不能为空")
    @Length(max=100, message="课程名称长度应小于100")
    @TableField()
    private String name;

    // 课程老师
    @NotNull(message = "课程老师不能为空")
    @Length(max=20, message="课程老师长度应小于20")
    @TableField()
    private String teacher;

    // 课程教室
    @NotNull(message = "课程教室不能为空")
    @Length(max=100, message="课程教室长度应小于100")
    @TableField()
    private String location;

    // 课程周数
    @NotNull(message = "课程周数不能为空")
    @TableField()
    private Long week;

    // 课程星期数
    @NotNull(message = "课程星期数不能为空")
    @TableField()
    private Long day;

    // 课程开始节数
    @NotNull(message = "课程开始节数不能为空")
    @TableField()
    private Long begin;

    // 课程共几节
    @NotNull(message = "课程共几节不能为空")
    @TableField()
    private Long rowSpan;

    @TableField(exist = false)
    private boolean deleted;

    @TableField(exist = false)
    private Date createTime;

}
