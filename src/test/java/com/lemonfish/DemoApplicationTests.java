package com.lemonfish;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lemonfish.pojo.entity.Course;
import com.lemonfish.service.CourseService;
import com.lemonfish.util.MailUtil;
import com.lemonfish.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    CourseService courseService;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    MailUtil mailUtil;


    @Test
    void contextLoads() {
        List<List<Course>> res = new ArrayList<>();

        LambdaQueryWrapper<Course> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Course::getWeek, 1);
        List<Course> entityList = courseService.getEntityList(lqw);
        for (long i = 1; i < 7; i++) {
            long begin = (i << 1) - 1;
            List<Course> coursesPerDay = entityList.stream().filter(item -> item.getBegin() == begin).collect(Collectors.toList());
            if (coursesPerDay.size() > 0) {
                res.add(coursesPerDay);
            }
        }

        System.out.println(res.size());
    }

    @Test
    void test01() {


    }
}
