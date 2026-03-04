package com.shubham.mcpclient.config;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.AsyncMcpToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIconfig {

    @Bean
    public ChatClient chatClient(
            ChatClient.Builder chatClientBuilder,
            AsyncMcpToolCallbackProvider toolCallbackProvider
    ) {
        return chatClientBuilder
                .defaultSystem("""
You are an AI medical assistant.
Use available MCP tools whenever useful.
""")
                .defaultToolCallbacks(toolCallbackProvider.getToolCallbacks())
                .build();
    }


}
