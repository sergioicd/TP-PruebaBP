package com.example.demo.services;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.exceptions.NoDataFoundException;
import com.example.demo.models.Cliente;
import com.example.demo.repositories.ClienteRepository;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceImplTest{

	@InjectMocks
	private ClienteServiceImpl clienteServiceImpl;
		
	@Mock
	private ClienteRepository clienteRepository;
		
	private Cliente cliente;
	
	@BeforeEach
	public void setup() {
		cliente = new Cliente();
		cliente.setClienteId(1L);
		cliente.setNombre("Fabian");
		cliente.setIdentificacion("80849999");
		
	}
		
	@Test
	public void testConsultarClienteNotFound() {
		when(clienteRepository.findById(2L)).thenThrow(new NoDataFoundException("No existe el cliente."));
		Exception exception = assertThrows(NoDataFoundException.class, () -> clienteRepository.findById(2L));
		assertEquals("No existe el cliente.", exception.getMessage());
	}
	
	@Test
	public void testConsultarCliente() {
		when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        Cliente result = clienteServiceImpl.consultarCliente(1L);
		assertNotNull(result);
		assertEquals(cliente.getClienteId(), result.getClienteId());
	}
	
			
	public void testEliminarCliente() throws Exception {
		when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
		doNothing().when(clienteRepository).deleteById(cliente.getClienteId());
		
	}
	
}