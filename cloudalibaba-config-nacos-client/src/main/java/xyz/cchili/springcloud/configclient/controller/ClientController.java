package xyz.cchili.springcloud.configclient.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cchili.springcloud.cloudapicommons.vo.Result;

/**
 * @author CQSuagr
 * @date 创建时间:2020/6/23 18:01
 */
@RestController
@RefreshScope
public class ClientController {

    @Value("${song.name}")
    private String name;

    @Value("${spring.application.name}")
    private String springName;

    @GetMapping("/name")
    public Result name() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("spirngName", springName);
        return new Result<>(true, jsonObject);
    }
}
