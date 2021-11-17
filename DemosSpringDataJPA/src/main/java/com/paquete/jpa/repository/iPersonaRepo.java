package com.paquete.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paquete.jpa.model.Persona;

public interface iPersonaRepo extends JpaRepository<Persona, Integer> {

}
