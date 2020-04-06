package com.lemonfish.controller;

import com.lemonfish.pojo.entity.Mail;
import com.lemonfish.service.MailService;
import com.lemonfish.util.MailUtil;
import com.lemonfish.util.MyJsonResult;
import com.lemonfish.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Chao Zhang
 * @version V1.0
 * @Package com.lemonfish.controller
 * @date 2020/4/5 22:35
 */
@RestController
@RequestMapping("/mail")
@Slf4j
public class MailController {
    @Autowired
    MailService mailService;


    @PostMapping("/")
    public MyJsonResult plusStar(@RequestBody Mail mail) {
        mailService.sendSuggestion(mail);
        return MyJsonResult.success(null);
    }

}
