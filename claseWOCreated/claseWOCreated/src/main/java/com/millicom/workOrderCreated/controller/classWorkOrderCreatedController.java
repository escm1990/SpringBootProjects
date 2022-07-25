package com.millicom.workOrderCreated.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@RestController
@RequestMapping(path= "/api")
public class classWorkOrderCreatedController {
	
	HttpStatus estado;

	@RequestMapping(value="/WOCreated", method = RequestMethod.POST)
	ResponseEntity<String> classWOC(@RequestBody String body){
		Random rand = new Random();
		int int_random = rand.nextInt(5); 
		String mensaje = "Exito "+int_random;
		estado=HttpStatus.OK;
		if(int_random==2||int_random==3) {
			estado=	HttpStatus.BAD_REQUEST;
			mensaje="Error "+int_random;
		}		
		return new ResponseEntity<String>(mensaje,estado);
	}	
}
