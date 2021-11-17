package com.consola.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.consola.repository.iPersonaRepo;

@Service
public class iPersonaServiceImpl implements iPersonaService {

	@Autowired
	@Qualifier("persona1")
	private iPersonaRepo repo;
	
	@Override
	public void registrar(String nombre) {
		repo.registrar(nombre);
	}

}
