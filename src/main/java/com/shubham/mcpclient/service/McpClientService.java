package com.shubham.mcpclient.service;

import com.shubham.mcpclient.agents.SupervisorAgent;
import io.modelcontextprotocol.client.McpAsyncClient;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.mcp.AsyncMcpToolCallbackProvider;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.stereotype.Service;

@Service
public class McpClientService {

    private final SupervisorAgent supervisorAgent;

    public McpClientService(SupervisorAgent supervisorAgent) {
        this.supervisorAgent = supervisorAgent;
    }

    public String processInput(String message) {

        return supervisorAgent.coordinate(message);

    }
}