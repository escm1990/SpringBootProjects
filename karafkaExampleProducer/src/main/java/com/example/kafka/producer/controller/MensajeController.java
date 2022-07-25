package com.example.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.producer.dto.Mensaje;
import com.example.kafka.producer.service.MensajeService;

@RestController
@RequestMapping("/mensaje")
public class MensajeController {

	   @Autowired
	    MensajeService ms;


	    @PostMapping
	    public void publishMensaje(@RequestBody Mensaje msj) throws Exception{
	         ms.publishMensaje(msj);
	    }
	    
}
