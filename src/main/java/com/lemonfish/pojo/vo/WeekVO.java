package com.lemonfish.pojo.vo;

import com.diboot.core.binding.annotation.*;
import com.lemonfish.pojo.entity.Week;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
* 教学周 VO定义
* @author Lemonfish
* @version 1.0
* @date 2020-03-25
 * Copyright © Chao Zhang
*/
@Getter @Setter @Accessors(chain = true)
public class WeekVO extends Week  {
    private static final long serialVersionUID = 5997860715277923826L;

}