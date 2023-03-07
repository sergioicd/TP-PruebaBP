package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.GeneralServiceException;
import com.example.demo.exceptions.NoDataFoundException;
import com.example.demo.exceptions.ValidateServiceException;
import com.example.demo.models.Movimiento;
import com.example.demo.repositories.MovimientoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovimientoServiceImpl implements MovimientoService{

	@Autowired
	MovimientoRepository movimientoRepository;
	
	@Override
	public void crearMovimiento(Long cuentaId, Movimiento movimiento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Movimiento consultarMovimiento(Long movimientoId) {
		try {
			Movimiento movimiento = movimientoRepository.findById(movimientoId).orElseThrow(()-> new NoDataFoundException("No se ha realizado este movimiento."));		
			return movimiento;
		} catch (ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Movimiento> consultarMovimientosPorCuenta(Long cuentaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movimiento> consultarEstadoDeCuentaPorCliente(Long clienteId, LocalDateTime fechaInicio,
			LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		return null;
	}

}
