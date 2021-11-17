package com.paquete.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemosSpringMvcApplication  implements CommandLineRunner{

private static Logger LOG = LoggerFactory.getLogger(DemosSpringMvcApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemosSpringMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Juanito");	
	}

}
