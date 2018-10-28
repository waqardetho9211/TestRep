package com.landon.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.landon.chat.model.ChatInMessage;
import com.landon.chat.model.ChatOutMessage;

public class ChatController {

	 public ChatOutMessage handleMessaging(ChatInMessage message) throws Exception {
            	
        return new ChatOutMessage();
    }

}
