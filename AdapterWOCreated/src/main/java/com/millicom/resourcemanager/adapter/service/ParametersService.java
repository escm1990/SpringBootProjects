package com.millicom.resourcemanager.adapter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millicom.resourcemanager.adapter.repository.ParametersRepository;

@Service
public class ParametersService {

	@Autowired
	ParametersRepository repo;
	
	public String obtenerPathByCodigo(String codigo) {
		return repo.findValorByCodigo(codigo);
	}
}
