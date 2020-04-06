package com.lemonfish.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.diboot.core.vo.JsonResult;
import com.diboot.core.vo.KeyValue;
import com.lemonfish.enumcode.CodeEnum;
import com.lemonfish.util.MyJsonResult;
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
* 教学周 相关Controller
* @author Lemonfish
* @version 1.0
* @date 2020-03-25
* Copyright © Chao Zhang
*/
@RestController
@RequestMapping("/week")
@Slf4j
public class WeekController extends BaseCrudMappingRestController<Week, WeekVO> {
    @Autowired
    private WeekService weekService;

    @GetMapping("/all")
    public MyJsonResult getAll() {
        List<Week> entityList = weekService.getEntityList(null);
        if (entityList.size() > 0) {
            return MyJsonResult.success(entityList);
        }
        return MyJsonResult.fail(CodeEnum.FAIL_NOT_FOUND);
    }

}
