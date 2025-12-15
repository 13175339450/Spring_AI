package com.hxl.spring.ai.config;

import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatOptions;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 多模型配置
 *
 * @author hengxiaoliang
 */
@Configuration
public class MultiModelConfig {

    /**
     * TODO: @Value只能注入实例域变量，不能注入静态域变量
     */
    @Value("${spring.ai.dashscope.api-key}")
    private String apiKey;

    private static final String DEEPSEEK = "deepseek-v3.2";

    private static final String QWEN = "qwen3-max";

    @Bean
    public ChatModel deepseekModel() {
        return DashScopeChatModel.builder()
                .dashScopeApi(DashScopeApi.builder().apiKey(apiKey).build())
                .defaultOptions(DashScopeChatOptions.builder().withModel(DEEPSEEK).build())
                .build();
    }

    @Bean
    public ChatModel qwenModel() {
        return DashScopeChatModel.builder()
                .dashScopeApi(DashScopeApi.builder().apiKey(apiKey).build())
                .defaultOptions(DashScopeChatOptions.builder().withModel(QWEN).build())
                .build();
    }
}
