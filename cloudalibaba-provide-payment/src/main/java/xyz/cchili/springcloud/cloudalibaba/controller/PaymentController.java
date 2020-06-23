package xyz.cchili.springcloud.cloudalibaba.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xyz.cchili.springcloud.cloudapicommons.vo.Result;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/23 9:50
 */
@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/port/{name}")
    public Result getPort(@PathVariable String name) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("port", port);
        jsonObject.put("name", name);
        log.info("port:{}  name:{}", port, name);
        return new Result<>(true, jsonObject);
    }

}
