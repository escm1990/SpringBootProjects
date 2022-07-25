package com.example.kafka.consumer.listeners;

import org.springframework.stereotype.Component;

import com.example.kafka.consumer.dto.Mensaje;
import com.example.kafka.consumer.util.GenerarArchivo;

@Component
public class KafkaListener {


	   @org.springframework.kafka.annotation.KafkaListener(groupId ="groups", topics = "${cloudkarafka.topic}" )
	    public void listen(Mensaje data) {
	        System.out.println("Impresión de mensaje: "+data);
	        
	        GenerarArchivo.generarArchivo(data);
	    }
	   
}
