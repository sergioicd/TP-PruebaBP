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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.converters.CuentaConverter;
import com.example.demo.dtos.ClienteDto;
import com.example.demo.dtos.CuentaDto;
import com.example.demo.models.Cliente;
import com.example.demo.services.ClienteService;
import com.example.demo.services.CuentaService;

@RestController
public class CuentaController {

	@Autowired
	CuentaService cuentaService;

	@Autowired
	ClienteService clienteService;
	
	private CuentaConverter converter = new CuentaConverter();
	
	@GetMapping(value="/cuentas/{cuentaId}")
	public ResponseEntity<CuentaDto> findById(@PathVariable("cuentaId") Long cuentaId){
		CuentaDto cuentaDto = converter.fromEntity(cuentaService.consultarCuenta(cuentaId));
		return new ResponseEntity<CuentaDto>(cuentaDto, HttpStatus.OK);	
	}
	
	@PostMapping(value="/cuentas")
	public ResponseEntity<Void> create(@RequestParam Long clienteId, @RequestBody CuentaDto cuentaDto){
		Cliente cliente = clienteService.consultarCliente(clienteId);
		cuentaService.crearCuenta(cliente, converter.fromDto(cuentaDto));
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping(value="/cuentas/{cuentaId}")
	public ResponseEntity<CuentaDto> update(@PathVariable("cuentaId") Long cuentaId, 
			@RequestBody CuentaDto cuentaDto){
		CuentaDto cuentaDtoUpdated = converter.fromEntity(
				cuentaService.editarCuenta(cuentaId, converter.fromDto(cuentaDto)));
		return new ResponseEntity<CuentaDto>(cuentaDtoUpdated, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/cuentas/{cuentaId}")
	public ResponseEntity<Void> deleteById(@PathVariable("cuentaId") Long cuentaId){
		cuentaService.eliminarCuenta(cuentaId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
