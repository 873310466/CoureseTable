package com.lemonfish.pojo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.diboot.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
* 自定义BaseEntity，对diboot-core的BaseEntity做差异化定义
* @author Lemonfish
* @version 1.0
* @date 2020-03-24
* Copyright © Chao Zhang
*/
@Getter @Setter @Accessors(chain = true)
public class BaseCustomEntity extends BaseEntity {
    private static final long serialVersionUID = -3773525912191997125L;


}
