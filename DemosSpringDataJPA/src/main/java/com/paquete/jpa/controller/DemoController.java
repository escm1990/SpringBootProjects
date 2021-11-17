package com.paquete.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paquete.jpa.model.Persona;
import com.paquete.jpa.repository.iPersonaRepo;

@Controller
public class DemoController {

	@Autowired
	private iPersonaRepo repo;
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required = false, defaultValue = "Pedo") String name, Model model) {
		
		Persona p = new Persona();
		p.setIdPersona(1);
		p.setNombre("Juanito");
		repo.save(p);
		
		model.addAttribute("name", name);
		return "paginaSaludo";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("personas",repo.findAll());
		
		return "paginaSaludo";
	}
	
}
