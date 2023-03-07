package com.example.demo.converters;

import com.example.demo.dtos.ClienteDto;
import com.example.demo.models.Cliente;

public class ClienteConverter extends AbstractConverter<Cliente, ClienteDto> {

	@Override
	public ClienteDto fromEntity(Cliente entity) {		
		return ClienteDto.builder()
		.nombre(entity.getNombre())
		.direccion(entity.getDireccion())
		.identificacion(entity.getIdentificacion())
		.genero(entity.getGenero())
		.estado(entity.getEstado())
		.telefono(entity.getTelefono())
		.contrasena(entity.getContrasena())		
		.build();
	}

	@Override
	public Cliente fromDto(ClienteDto dto) {
		return Cliente.builder()
		.nombre(dto.getNombre())
		.direccion(dto.getDireccion())
		.identificacion(dto.getIdentificacion())
		.genero(dto.getGenero())
		.estado(dto.getEstado())
		.telefono(dto.getTelefono())
		.contrasena(dto.getContrasena())
		.build();
	}

}
