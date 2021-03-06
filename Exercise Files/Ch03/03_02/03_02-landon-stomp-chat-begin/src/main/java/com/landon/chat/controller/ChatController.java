package com.landon.chat.controller;

import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.landon.chat.model.ChatInMessage;
import com.landon.chat.model.ChatOutMessage;

@Controller
public class ChatController {

	 @MessageMapping("/guestchat")
	 @SendTo("/topic/guestchats")
	 public ChatOutMessage handleMessaging(ChatInMessage message) throws Exception {
        Thread.sleep(1000); // simulate delay
        
        return new ChatOutMessage(message.getMessage());
    }

	@MessageMapping("/guestupdate")
	@SendTo("/topic/guestupdates")
	public ChatOutMessage handleUserIsTyping(ChatInMessage message)  throws Exception {
		return new ChatOutMessage("Someone is typing...");
	}
	
    @MessageMapping("/guestjoin")
    @SendTo("/topic/guestnames")
    public ChatOutMessage handleMemberJoins(ChatInMessage message) throws Exception {
        return new ChatOutMessage(message.getMessage());
    }
    
	@MessageExceptionHandler
	@SendTo("/topic/errors")
	public String handleException(Throwable exception) {
		return exception.getMessage();
	}
}
