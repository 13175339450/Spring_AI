package com.hxl.spring.ai.controller;

import jakarta.annotation.Resource;
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

    @GetMapping("/deepseek")
    public Flux<String> deepseek(@RequestParam("msg") String msg) {
        return deepseekModel.stream(msg);
    }

    @GetMapping("/qwen")
    public Flux<String> qwen(@RequestParam("msg") String msg) {
        return qwenModel.stream(msg);
    }
}
