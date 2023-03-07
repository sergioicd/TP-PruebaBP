package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.converters.ClienteConverter;
import com.example.demo.dtos.ClienteDto;
import com.example.demo.services.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	private ClienteConverter converter = new ClienteConverter();
	
	
	@GetMapping(value="/clientes/{clienteId}")
	public ResponseEntity<ClienteDto> findById(@PathVariable("clienteId") Long clienteId){
		ClienteDto clienteDto = converter.fromEntity(clienteService.consultarCliente(clienteId));
		return new ResponseEntity<ClienteDto>(clienteDto, HttpStatus.OK);	
	}
	
	@PostMapping(value="/clientes")
	public ResponseEntity<Void> create(@RequestBody ClienteDto clienteDto){
		clienteService.crearCliente(converter.fromDto(clienteDto));
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping(value="/clientes/{clienteId}")
	public ResponseEntity<ClienteDto> update(@PathVariable("clienteId") Long clienteId, 
			@RequestBody ClienteDto clienteDto){
		ClienteDto clienteDtoUpdated = converter.fromEntity(
				clienteService.editarCliente(clienteId, converter.fromDto(clienteDto)));
		return new ResponseEntity<ClienteDto>(clienteDtoUpdated, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/clientes/{clienteId}")
	public ResponseEntity<Void> deleteById(@PathVariable("clienteId") Long clienteId){
		clienteService.eliminarCliente(clienteId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
