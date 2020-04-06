package com.lemonfish.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Chao Zhang
 * @version V1.0
 * @Package com.lemonfish.pojo.entity
 * @date 2020/4/5 23:45
 */
@Getter
@Setter
@Accessors(chain = true)
public class Mail implements Serializable {
    private static final long serialVersionUID = 9136992080821210089L;

    private String linkman;
    private String content;
}
