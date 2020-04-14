package com.lemonfish.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.diboot.core.service.impl.BaseServiceImpl;
import com.lemonfish.enumcode.CodeEnum;
import com.lemonfish.pojo.entity.Course;
import com.lemonfish.mapper.CourseMapper;
import com.lemonfish.service.CourseService;
import com.lemonfish.util.MyJsonResult;
import com.lemonfish.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* 相关Service实现
* @author Lemonfish
* @version 1.0
* @date 2020-03-24
 * Copyright © Chao Zhang
*/
@Service
@Slf4j
public class CourseServiceImpl extends BaseCustomServiceImpl<CourseMapper, Course> implements CourseService {
    public static final String COURSE_WEEK_ = "course_week_";
    @Autowired
    RedisUtil redisUtil;

    public MyJsonResult getWeekList(long week) {
        // 先从redis 缓存中找，如果没有就从数据库查询
        List<List<Course>> redisRes = (List<List<Course>>) redisUtil.get(COURSE_WEEK_ + week);
        // 如果找到，则直接返回
        if (redisRes != null) {
            System.out.println("我是redis");
            return MyJsonResult.success(redisRes);
        }

        // ==================在redis中没有找到，则从mysql寻找，并添加进redis========================
        System.out.println("我是mysql");
        // 课程表是一个二维的
        List<List<Course>> res = new ArrayList<>();

        LambdaQueryWrapper<Course> lqw = new LambdaQueryWrapper<>();
        // 获取周数为`week`的所有课程数据
        lqw.eq(Course::getWeek, week);
        List<Course> entityList = this.getEntityList(lqw);

        // 因为最多12节课一天
        for (long i = 1; i < 13; i++) {
            long begin = i;
            // 对得到的数据进行过滤，因为每节课的begin只可能是1 3 5 ... 11 这些奇数,其他数据为空即可
            List<Course> coursesPerDay = entityList.stream().filter(item -> item.getBegin() == begin).collect(Collectors.toList());
            // 添加到课程表中
            res.add(coursesPerDay);
        }

        // 添加进redis作缓存
        redisUtil.set(COURSE_WEEK_ + week, res);


        return res.size() > 0 ? MyJsonResult.success(res) : MyJsonResult.fail(CodeEnum.FAIL_NOT_FOUND);
    }
}
