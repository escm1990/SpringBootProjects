package com.millicom.resourcemanager.adapter.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.millicom.resourcemanager.adapter.dto.ApiResponse;
import com.millicom.resourcemanager.adapter.logger.WOCreatedLog;
import com.millicom.resourcemanager.adapter.service.ParametersService;
import com.millicom.resourcemanager.adapter.service.WOCreatedService;
import com.millicom.resourcemanager.adapter.util.ResponsEntityUtil;

@RestController
@RequestMapping(path= "/api/adapter")
public class WOCreatedController {

	@Autowired
	WOCreatedService service;
	
	@Autowired
	ParametersService repo;
	
	@Autowired
	private Environment env;
	
	@PostMapping(value="/WOCreated")
    public ResponseEntity<ApiResponse> process(@RequestBody JsonNode payload) throws IOException {
		try {

			String data = payload.toPrettyString();    
			ApiResponse ar = service.recibirJSON(data);

			//String codigo = env.getProperty("adapter.om.path");
			//String path = repo.obtenerPathByCodigo(codigo);
			
			String path = env.getProperty("adapter.om.path");
			String namefile = env.getProperty("adapter.om.namefile");
			
			//Generación de archivo log
	        WOCreatedLog.generarArchivo(path, namefile, data, ar.getData().toString());
        
	        return ResponsEntityUtil.responseApiOk(ar.getMessage(), ar.getData(), ar.getSuccess());
		}
		catch(Exception ex) {
			return ResponsEntityUtil.responseApiOk("Error", ex.getMessage(), false);
		}
    }
	
}
