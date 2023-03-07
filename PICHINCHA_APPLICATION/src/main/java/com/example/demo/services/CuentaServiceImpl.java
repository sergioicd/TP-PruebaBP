package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.GeneralServiceException;
import com.example.demo.exceptions.NoDataFoundException;
import com.example.demo.exceptions.ValidateServiceException;
import com.example.demo.models.Cliente;
import com.example.demo.models.Cuenta;
import com.example.demo.repositories.CuentaRepository;
import com.example.demo.validators.CuentaValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CuentaServiceImpl implements CuentaService{
	
	@Autowired
	CuentaRepository cuentaRepository;

	@Override
	public void crearCuenta(Cliente cliente, Cuenta cuenta) {
		try {
			cuenta.setCliente(cliente);
			cuentaRepository.save(cuenta);
		} catch (ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
	}

	@Override
	public Cuenta editarCuenta(Long cuentaId, Cuenta cuenta) {
		try {
			CuentaValidator.save(cuenta);
			Cuenta cuentaToUpdate = cuentaRepository.findById(cuentaId).orElseThrow(()-> new NoDataFoundException("No existe la cuenta."));
			Cuenta cuentaUpdated = setCuentaToUpdate(cuentaToUpdate, cuenta);
			return cuentaRepository.save(cuentaUpdated);
		} catch (ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	public Cuenta consultarCuenta(Long cuentaId) {
		try {
			Cuenta cuenta = cuentaRepository.findById(cuentaId).orElseThrow(()-> new NoDataFoundException("No existe la cuenta."));		
			return cuenta;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void eliminarCuenta(Long cuentaId) {
		try {
			Cuenta cuenta = cuentaRepository.findById(cuentaId).orElseThrow(()-> new NoDataFoundException("No existe la cuenta."));
			cuentaRepository.delete(cuenta);
		} catch (ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
	}
	
	private Cuenta setCuentaToUpdate(Cuenta cuentaToUpdate, Cuenta cuenta){
		cuentaToUpdate.setNumero(cuenta.getNumero());
		cuentaToUpdate.setSaldoInicial(cuenta.getSaldoInicial());
		cuentaToUpdate.setEstado(cuenta.getEstado());
		cuentaToUpdate.setTipo(cuenta.getTipo());
		return cuentaToUpdate;
	}

}
