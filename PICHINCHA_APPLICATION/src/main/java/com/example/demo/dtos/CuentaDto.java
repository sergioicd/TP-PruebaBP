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
public class CuentaDto {
	
	private Long cuentaId;
	private String numero;
	private String tipo;
	private Long saldoInicial;
	private Boolean estado;
	private ClienteDto cliente;

}
