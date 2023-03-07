package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.models.Cuenta;
import com.example.demo.models.Movimiento;

public interface MovimientoService {
	
	void crearMovimiento(Long cuentaId, Movimiento movimiento);
		
	Movimiento consultarMovimiento(Long movimientoId);
	
	List<Movimiento> consultarMovimientosPorCuenta(Long cuentaId);
	
	List<Movimiento> consultarEstadoDeCuentaPorCliente(Long clienteId, LocalDateTime fechaInicio, LocalDateTime fechaFin);

}
