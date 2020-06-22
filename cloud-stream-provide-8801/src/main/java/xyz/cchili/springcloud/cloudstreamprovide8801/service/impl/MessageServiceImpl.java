package xyz.cchili.springcloud.cloudstreamprovide8801.service.impl;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import xyz.cchili.springcloud.cloudstreamprovide8801.service.MessageService;

import javax.annotation.Resource;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/21 18:03
 */
@EnableBinding(Source.class)
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageChannel output;  //消息发送管道

    @Override
    public String send() {
        String uuid = IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(uuid).build());
        log.info("========{}=========", uuid);
        return "ok";
    }
}
