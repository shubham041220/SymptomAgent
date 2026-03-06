package com.shubham.mcpclient.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ExecutorAgent {

    private  final ChatClient chatClient;

    public ExecutorAgent(ChatClient chatClient) {
        this.chatClient = chatClient;
    }


    public String execute(String plan, String input) {

        String prompt = """
            Execute the following medical plan step by step.

                Plan:
                    %s

                User Input:
                     %s

                Use MCP tools if needed.
                
                """.formatted(plan, input);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}
