package com.example.demo.models;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@SuperBuilder
@Getter
@Setter
abstract class Persona {
	
	private String nombre;
	private String genero;
	private String identificacion;
	private String direccion;
	private String telefono;

}
