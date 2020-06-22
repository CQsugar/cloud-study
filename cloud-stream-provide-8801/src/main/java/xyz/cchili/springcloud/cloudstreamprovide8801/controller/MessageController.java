package xyz.cchili.springcloud.cloudstreamprovide8801.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cchili.springcloud.cloudstreamprovide8801.service.MessageService;

import javax.annotation.Resource;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/21 18:16
 */
@RestController
public class MessageController {

    @Resource
    private MessageService messageService;

    @GetMapping("/send")
    public String send() {
        return messageService.send();
    }
}
