package com.hxl.spring.ai.controller;

import com.hxl.spring.ai.entity.UserRecord;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 多格式输出控制器
 *
 * @author hengxiaoliang
 */
@RestController
public class MultiFormatController {

    @Resource
    private ChatClient deepseekClient;

    @GetMapping("multi1")
    public UserRecord multi1(@RequestParam("name") String name,
                                   @RequestParam("email") String email) {
        return deepseekClient.prompt()
                .user(promptUserSpec -> {
                    promptUserSpec.text("学号100001，姓名{name}, 年龄28, 邮箱{email}")
                            .param("name", name)
                            .param("email", email);
                }).call().entity(UserRecord.class);
    }

    @GetMapping("multi2")
    public UserRecord multi2(@RequestParam("name") String name,
                                   @RequestParam("email") String email) {
        String prompt = "学号100002，姓名{name}, 年龄18, 邮箱{email}";
        return deepseekClient.prompt()
                .user(promptUserSpec -> {
                    promptUserSpec.text(prompt)
                            .param("name", name)
                            .param("email", email);
                }).call().entity(UserRecord.class);
    }
}
