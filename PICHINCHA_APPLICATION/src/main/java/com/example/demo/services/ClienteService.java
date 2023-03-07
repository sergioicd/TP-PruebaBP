package com.example.demo.services;

import com.example.demo.models.Cliente;


public interface ClienteService {
	
	void crearCliente(Cliente cliente);
	
	Cliente editarCliente(Long clienteId, Cliente cliente);
	
	Cliente consultarCliente(Long clienteId);
	
	void eliminarCliente(Long clienteId);

}
