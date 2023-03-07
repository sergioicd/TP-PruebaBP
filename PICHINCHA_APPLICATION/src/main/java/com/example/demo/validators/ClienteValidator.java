package com.example.demo.validators;

import com.example.demo.exceptions.ValidateServiceException;
import com.example.demo.models.Cliente;

public class ClienteValidator {
	
	public static void save (Cliente cliente){
	
		if(cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
			throw new ValidateServiceException("El nombre es requerido.");
		}
		
		if(cliente.getIdentificacion() == null || cliente.getIdentificacion().trim().isEmpty()) {
			throw new ValidateServiceException("La identificación es requerida.");
		}
		
	}

}
