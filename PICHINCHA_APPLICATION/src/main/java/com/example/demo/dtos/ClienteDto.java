package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClienteDto {
	
	private String nombre;
	private String genero;
	private String identificacion;
	private String direccion;
	private String telefono;
	private String contrasena;
	private Boolean estado;
	
}
