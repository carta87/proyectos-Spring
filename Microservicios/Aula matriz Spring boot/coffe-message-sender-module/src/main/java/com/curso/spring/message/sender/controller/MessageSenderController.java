package com.curso.spring.message.sender.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.common.estities.NotificationMessage;

@RestController
@RequestMapping("/message-sender")
public class MessageSenderController {
	
	@PostMapping("/send")
	public void sendMessage(@RequestBody NotificationMessage message) {
		//TODO tafur Pendiente realizar la implementacion metodo de enviar
		
	}
	
	@GetMapping("/findAll")
	public List<NotificationMessage> findAll(){
		//TODO tafur Pendiente realizar la implementacion metodo encontar lista
		return null;
	}
	

}
