package com.hxl.spring.ai.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author hengxiaoliang
 */
@RestController
public class AlibabaSimpleController {

    @Resource
    private ChatModel chatModel;

    @GetMapping("/simple")
    public Flux<String> simple(@RequestParam("msg") String msg) {
        return chatModel.stream(msg);
    }
}
