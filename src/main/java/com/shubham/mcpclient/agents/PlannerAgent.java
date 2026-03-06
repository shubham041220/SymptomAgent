package com.shubham.mcpclient.agents;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;


@Component
public class PlannerAgent {

    private final ChatClient chatClient;

    public PlannerAgent(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String createPlan(String input) {

        return chatClient.prompt()
                .system("""
You are a medical planning agent.

Create a step-by-step plan to solve the user's problem.

Return steps in JSON array.
""")
                .user(input)
                .call()
                .content();
    }
}
