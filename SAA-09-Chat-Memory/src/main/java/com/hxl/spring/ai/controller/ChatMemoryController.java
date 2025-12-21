package com.hxl.spring.ai.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static org.springframework.ai.chat.memory.ChatMemory.CONVERSATION_ID;

/**
 * 聊天记忆控制器
 *
 * @author hengxiaoliang
 */
@RestController
public class ChatMemoryController {

    @Resource
    private ChatClient qwenClient;

    @Resource
    private ChatClient deepseekClient;

    @GetMapping("/qwen")
    public Flux<String> qwenQuestion(@RequestParam("msg") String msg,
                                     @RequestParam("userId") Long userId) {
        return qwenClient.prompt(msg)
                .advisors(advisorSpec -> advisorSpec.param(CONVERSATION_ID, userId))
                .stream()
                .content();
    }

    @GetMapping("/deepseek")
    public Flux<String> deepseekQuestion(@RequestParam("msg") String msg,
                                         @RequestParam("userId") Long userId) {
        return deepseekClient.prompt(msg)
                .advisors(advisorSpec -> advisorSpec.param(CONVERSATION_ID, userId))
                .stream()
                .content();
    }
}
