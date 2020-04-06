package com.lemonfish.service.impl;

import com.lemonfish.pojo.entity.Mail;
import com.lemonfish.service.MailService;
import com.lemonfish.util.MailUtil;
import com.lemonfish.util.MyJsonResult;
import com.lemonfish.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Chao Zhang
 * @version V1.0
 * @Package com.lemonfish.service.impl
 * @date 2020/4/5 23:49
 */
@Service
public class MailServiceImpl implements MailService {
    @Autowired
    MailUtil mailUtil;
    @Autowired
    RedisUtil redisUtil;
    @Override
    public void sendSuggestion(Mail mail) {
        String linkman = mail.getLinkman();
        if ("".equals(linkman)) {
            linkman = "匿名的小伙伴";
        }
        String content = mail.getContent();
        mailUtil.sendMail("873310466@qq.com", "来自“课程表”的留言~", "<h1>From : " + linkman + "</h1> " + "<h3>Content : " + content + "</h3>");
        redisUtil.incr("mailSum", 1);
    }
}
