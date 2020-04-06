package com.lemonfish.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.diboot.core.vo.JsonResult;
import com.diboot.core.vo.KeyValue;
import com.lemonfish.enumcode.CodeEnum;
import com.lemonfish.util.MyJsonResult;
import com.lemonfish.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.lemonfish.pojo.entity.Week;
import com.lemonfish.service.WeekService;
import com.lemonfish.pojo.vo.WeekVO;

import lombok.extern.slf4j.Slf4j;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 点击加星星的 Controller
 * @author Lemonfish
 * @version 1.0
 * @date 2020-03-25
 * Copyright © Chao Zhang
 */
@RestController
@RequestMapping("/stars")
@Slf4j
public class StarsController  {
    @Autowired
    private RedisUtil redisUtil;

    @PutMapping("/")
    public MyJsonResult plusStar() {
        long stars = redisUtil.incr("stars", 1);
        return MyJsonResult.success(stars);
    }

    @GetMapping("/")
    public MyJsonResult getStar() {
        return MyJsonResult.success(redisUtil.get("stars"));
    }

}
