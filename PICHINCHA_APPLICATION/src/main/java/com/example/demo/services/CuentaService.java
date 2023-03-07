package com.example.demo.services;

import com.example.demo.models.Cliente;
import com.example.demo.models.Cuenta;

public interface CuentaService {
	
	void crearCuenta(Cliente cliente, Cuenta cuenta);
	
	Cuenta editarCuenta(Long cuentaId, Cuenta cuenta);
	
	Cuenta consultarCuenta(Long cuentaId);
	
	void eliminarCuenta(Long cuentaId);

}
