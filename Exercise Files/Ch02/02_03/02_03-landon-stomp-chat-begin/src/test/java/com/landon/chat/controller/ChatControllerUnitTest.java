package com.landon.chat.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.landon.chat.model.ChatInMessage;

@RunWith(SpringRunner.class)
@WebMvcTest(ChatController.class)

public class ChatControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testChat() throws Exception {
		
		// simulate the form submit (POST)
		mockMvc
			.perform(get("/hello", new ChatInMessage("Hey there")))
			.andExpect(status().isOk())
			.andReturn();
	}

}
