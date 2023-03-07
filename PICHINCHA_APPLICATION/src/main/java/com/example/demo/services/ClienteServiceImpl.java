package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exceptions.GeneralServiceException;
import com.example.demo.exceptions.NoDataFoundException;
import com.example.demo.exceptions.ValidateServiceException;
import com.example.demo.models.Cliente;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.validators.ClienteValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	@Transactional
	public void crearCliente(Cliente cliente) {
		try {
			ClienteValidator.save(cliente);
			clienteRepository.save(cliente);
		} catch (ValidateServiceException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
	}

	@Override
	@Transactional
	public Cliente editarCliente(Long clienteId, Cliente cliente) {
		try {
			ClienteValidator.save(cliente);
			Cliente clienteToUpdate = clienteRepository.findById(clienteId).orElseThrow(()-> new NoDataFoundException("No existe el cliente."));
			Cliente clienteUpdated = setClienteToUpdate(clienteToUpdate, cliente);
			clienteRepository.save(clienteUpdated);
			return clienteUpdated;	
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
	}

	@Override
	public Cliente consultarCliente(Long clienteId) {	
		try {
			Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(()-> new NoDataFoundException("No existe el cliente."));		
			return cliente;
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
		
	}

	@Override
	@Transactional
	public void eliminarCliente(Long clienteId) {
		try {
			Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(()-> new NoDataFoundException("No existe el cliente."));
			clienteRepository.delete(cliente);	
		} catch (ValidateServiceException | NoDataFoundException e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new GeneralServiceException(e.getMessage(), e);
		}
			
	}
	
	private Cliente setClienteToUpdate(Cliente clienteToUpdate, Cliente cliente) {
		clienteToUpdate.setNombre(cliente.getNombre());
		clienteToUpdate.setDireccion(cliente.getDireccion());
		clienteToUpdate.setEstado(cliente.getEstado());
		clienteToUpdate.setGenero(cliente.getGenero());
		clienteToUpdate.setIdentificacion(cliente.getIdentificacion());
		clienteToUpdate.setTelefono(cliente.getTelefono());
		clienteToUpdate.setContrasena(cliente.getContrasena());
		return clienteToUpdate;
	}

}
