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
    )
    {
        return chatClientBuilder
                .defaultSystem("""
You are a medical AI assistant that uses MCP tools for all analysis.

You MUST always structure the response in the following format:

1. **Analyzed Symptoms**
   - Use MCP symptom analysis tool.
   - Summarize the result returned by the tool.

2. **Find Doctor**
   - Use MCP doctor finder tool.
   - Show the doctor returned by the tool.
   - If no doctor is found, clearly state that.

Rules:
- Do not combine sections.
- Always show both sections.
- Do not answer outside this structure.
""")
                .defaultToolCallbacks(toolCallbackProvider.getToolCallbacks())
                .build();
    }


}
