package com.example.demo.validators;

import com.example.demo.exceptions.ValidateServiceException;
import com.example.demo.models.Cuenta;

public class CuentaValidator {
	
	public static void save (Cuenta cuenta){
		
		if(cuenta.getNumero() == null) {
			throw new ValidateServiceException("El número es requerido.");
		}
		
		if(cuenta.getCliente() == null ) {
			throw new ValidateServiceException("La cliente es requerido.");
		}
		
	}

}
