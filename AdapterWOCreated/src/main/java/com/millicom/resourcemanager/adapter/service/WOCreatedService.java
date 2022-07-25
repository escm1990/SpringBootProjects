package com.millicom.resourcemanager.adapter.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.millicom.resourcemanager.adapter.dto.ApiResponse;
import com.millicom.resourcemanager.adapter.repository.ParametersRepository;

@Service
public class WOCreatedService {

	@Autowired
	ParametersRepository repo;
	
	@Autowired
	private Environment env;
	
	public ApiResponse recibirJSON(String data) {
		
		 try {
			 	
			//String codigo = env.getProperty("adapter.om.url");
			//String postEndpoint = repo.findValorByCodigo(codigo);
			 
			 String postEndpoint = env.getProperty("adapter.om.url");
			 String inputJson = data;

			boolean estado = true;
			String mensaje = "Exito";

			var request = HttpRequest.newBuilder().uri(URI.create(postEndpoint))
					.header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(inputJson))
					.build();

			var client = HttpClient.newHttpClient();

			var response = client.send(request, HttpResponse.BodyHandlers.ofString());

			if (response.statusCode() != 200) {
				estado = false;
				mensaje = "Error";
			}

			return new ApiResponse(estado, mensaje, response.body().toString());
		} catch (Exception e) {
			return new ApiResponse(false, "Error inesperado", e.getMessage());
		}
	}

}
