package com.example.JuliusCaesarChatbot.controller;

import com.example.JuliusCaesarChatbot.service.CaesarChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "*")
public class ChatController {
    @Autowired
    private CaesarChatService service;

    @PostMapping
    public Map <String, String> chat (@RequestBody Map <String, String> payload) {
        String userMessage = payload.get ("message");
        String caesarResponse = this.service.getCaesarResponse (userMessage);
        return Map.of ("response", caesarResponse);
    }
}
