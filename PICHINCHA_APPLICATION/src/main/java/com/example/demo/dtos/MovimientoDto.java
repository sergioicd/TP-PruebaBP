package com.example.demo.dtos;

import java.time.LocalDateTime;

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
public class MovimientoDto {
	
	private Long idMovimiento;
	private LocalDateTime fecha;
	private String tipo;
	private Double valor;
	private Double saldo;
	private CuentaDto cuenta;


}
