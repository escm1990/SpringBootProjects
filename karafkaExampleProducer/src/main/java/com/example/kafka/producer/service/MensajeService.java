package com.example.kafka.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafka.producer.dto.Mensaje;

@Service
public class MensajeService {

	  @Autowired
	    private KafkaTemplate<Integer, Mensaje> kafkaTemplate;

	    @Value("${cloudkarafka.topic}")
	    private String topic;

	    public void publishMensaje(Mensaje msj) {

	            kafkaTemplate.send(topic,msj.getId(),msj).addCallback(
	                        result ->System.out.println("Message published successfully to topic: \n"+ result.getProducerRecord()),
	                        ex -> System.out.println("Failed to send message"+ ex)
	                );
	    }

	    
}
