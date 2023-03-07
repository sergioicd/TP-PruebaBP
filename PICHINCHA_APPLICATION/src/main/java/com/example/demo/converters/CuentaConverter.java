package com.example.demo.converters;

import com.example.demo.dtos.ClienteDto;
import com.example.demo.dtos.CuentaDto;
import com.example.demo.models.Cliente;
import com.example.demo.models.Cuenta;

public class CuentaConverter extends AbstractConverter<Cuenta, CuentaDto>{

	@Override
	public CuentaDto fromEntity(Cuenta entity) {
		
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setNombre(entity.getCliente().getNombre());
		clienteDto.setDireccion(entity.getCliente().getIdentificacion());
		clienteDto.setTelefono(entity.getCliente().getTelefono());
		clienteDto.setGenero(entity.getCliente().getGenero());
		clienteDto.setIdentificacion(entity.getCliente().getIdentificacion());
		clienteDto.setEstado(entity.getCliente().getEstado());
		clienteDto.setContrasena(entity.getCliente().getContrasena());
		
		return CuentaDto.builder()
		.numero(entity.getNumero())
		.estado(entity.getEstado())
		.saldoInicial(entity.getSaldoInicial())
		.tipo(entity.getTipo())
		.cliente(clienteDto)
		.build();
		
	}

	@Override
	public Cuenta fromDto(CuentaDto dto) {
		
		Cliente cliente = new Cliente();
		
		if(dto.getCliente() != null) {
			cliente.setNombre(dto.getCliente().getNombre());
			cliente.setDireccion(dto.getCliente().getDireccion());
			cliente.setEstado(dto.getCliente().getEstado());
			cliente.setGenero(dto.getCliente().getGenero());
			cliente.setIdentificacion(dto.getCliente().getIdentificacion());
			cliente.setContrasena(dto.getCliente().getContrasena());
			cliente.setTelefono(dto.getCliente().getTelefono());	
		}
		
		return Cuenta.builder()
		.numero(dto.getNumero())
		.estado(dto.getEstado())
		.saldoInicial(dto.getSaldoInicial())
		.tipo(dto.getTipo())
		.cliente(cliente)
		.build();
		
	}

}
