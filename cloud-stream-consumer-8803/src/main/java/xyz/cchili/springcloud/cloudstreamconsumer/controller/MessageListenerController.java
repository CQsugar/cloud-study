package xyz.cchili.springcloud.cloudstreamconsumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/21 19:02
 */
@EnableBinding(Sink.class)
@Controller
@Slf4j
public class MessageListenerController {
    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("============{}:{}=============", message.getPayload(), port);
    }

}
