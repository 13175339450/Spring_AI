package com.hxl.spring.ai.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * 多模型控制器
 *
 * @author hengxiaoliang
 */
@RestController
public class MultiModelController {

    /**
     * TODO: 默认按照变量名称注入
     */
    @Resource
    private ChatModel deepseekModel;

    @Resource
    private ChatModel qwenModel;

    @Resource
    private ChatClient deepseekClient;

    @Resource
    private ChatClient qwenClient;


    // ------------------------------ ChatModel -----------------------------

    @GetMapping("/qwen")
    public Flux<String> qwen(@RequestParam("msg") String msg) {
        return qwenModel.stream(msg);
    }

    @GetMapping("/deepseek")
    public Flux<String> deepseek(@RequestParam("msg") String msg) {
        return deepseekModel.stream(msg);
    }

    // ------------------------------ ChatModel -----------------------------

    @GetMapping("/qwenClient")
    public Flux<String> qwenClient(@RequestParam("msg") String msg) {
        return qwenClient.prompt()
                .user(msg)
                .stream()
                .content();
    }

    @GetMapping("/deepseekClient")
    public Flux<String> deepseekClient(@RequestParam("msg") String msg) {
        return deepseekClient.prompt()
                .user(msg)
                .stream()
                .content();
    }
}
