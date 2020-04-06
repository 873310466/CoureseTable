package com.lemonfish.service;

import com.lemonfish.pojo.entity.Mail;
import com.lemonfish.util.MyJsonResult;

/**
 * @author Chao Zhang
 * @version V1.0
 * @Package com.lemonfish.service
 * @date 2020/4/5 23:47
 */
public interface MailService {
    void sendSuggestion(Mail mail);
}
