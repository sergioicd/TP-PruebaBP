package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.converters.MovimientoConverter;
import com.example.demo.dtos.MovimientoDto;
import com.example.demo.services.MovimientoService;

@RestController
public class MovimientoController {
	
	@Autowired
	MovimientoService movimientoService;
	
	MovimientoConverter converter = new MovimientoConverter();

	@GetMapping(value="/movimientos/{movimientoId}")
	public ResponseEntity<MovimientoDto> findById(@PathVariable("movimientoId") Long movimientoId){
		MovimientoDto movimientoDto = converter.fromEntity(movimientoService.consultarMovimiento(movimientoId));
		return new ResponseEntity<MovimientoDto>(movimientoDto, HttpStatus.OK);	
	}
	
}
