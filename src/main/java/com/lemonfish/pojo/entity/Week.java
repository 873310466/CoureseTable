package com.lemonfish.pojo.entity;

import java.util.Date;
import javax.validation.constraints.NotNull;
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
* 教学周 Entity定义
* @author Lemonfish
* @version 1.0
* @date 2020-03-25
* Copyright © Chao Zhang
*/
@Getter @Setter @Accessors(chain = true)
public class Week extends BaseCustomEntity {
    private static final long serialVersionUID = -7399853980561117244L;


    // 教学周
    @TableField()
    private Long cweek;

}
