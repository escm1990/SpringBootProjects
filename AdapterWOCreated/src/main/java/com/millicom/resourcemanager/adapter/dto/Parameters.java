package com.millicom.resourcemanager.adapter.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Parameters {

	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;
	  
	  private String codigo;
	  
	  private String grupo;
	  
	  private String valor;
	  
	  private String credenciales;
	
}
