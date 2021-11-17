package com.consola.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.consola.DemoConsolaApplication;

@Repository
@Qualifier("persona1")
public class PersonaRepoImpl1 implements iPersonaRepo{

	private static Logger LOG = LoggerFactory.getLogger(DemoConsolaApplication.class);
	
	@Override
	public void registrar(String nombre) {
		LOG.info("Se registro(1): "+nombre);
		
	}

}
