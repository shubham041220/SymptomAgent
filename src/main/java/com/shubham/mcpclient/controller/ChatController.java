package com.shubham.mcpclient.controller;

import com.shubham.mcpclient.service.McpClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {


    private final McpClientService mcpClientService;

    public ChatController(McpClientService mcpClientService) {
        this.mcpClientService = mcpClientService;
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String message) {
        return mcpClientService.sendMessage(message);
    }
}
