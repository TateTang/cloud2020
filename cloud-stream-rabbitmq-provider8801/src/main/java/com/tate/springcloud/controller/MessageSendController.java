package com.tate.springcloud.controller;

import com.tate.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tangmf
 * @Date 2021/4/8 9:34 下午
 * @Description
 */
@RestController
public class MessageSendController {
    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}
