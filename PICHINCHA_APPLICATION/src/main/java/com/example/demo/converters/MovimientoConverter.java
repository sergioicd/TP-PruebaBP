package com.example.demo.converters;

import com.example.demo.dtos.ClienteDto;
import com.example.demo.dtos.CuentaDto;
import com.example.demo.dtos.MovimientoDto;
import com.example.demo.models.Cuenta;
import com.example.demo.models.Movimiento;

public class MovimientoConverter extends AbstractConverter<Movimiento, MovimientoDto>{

	@Override
	public MovimientoDto fromEntity(Movimiento entity) {
		
		ClienteDto cliente = new ClienteDto();
		cliente.setIdentificacion(entity.getCuenta().getCliente().getIdentificacion());
		
		CuentaDto cuenta = new CuentaDto();
		cuenta.setCuentaId(entity.getCuenta().getCuentaId());
		cuenta.setNumero(entity.getCuenta().getNumero());
		cuenta.setTipo(entity.getCuenta().getTipo());
		cuenta.setEstado(entity.getCuenta().getEstado());
		cuenta.setSaldoInicial(entity.getCuenta().getSaldoInicial());
		cuenta.setCliente(cliente);
		
		return MovimientoDto.builder()
		.idMovimiento(entity.getIdMovimiento())
		.valor(entity.getValor())
		.saldo(entity.getSaldo())
		.tipo(entity.getTipo())
		.fecha(entity.getFecha())
		.cuenta(cuenta)
		.build();
		
	}

	@Override
	public Movimiento fromDto(MovimientoDto dto) {
		
		Cuenta cuenta = new Cuenta();
		cuenta.setNumero(dto.getCuenta().getNumero());
		cuenta.setTipo(dto.getCuenta().getTipo());
		cuenta.setEstado(dto.getCuenta().getEstado());
		cuenta.setSaldoInicial(dto.getCuenta().getSaldoInicial());
		
		return Movimiento.builder()
		.saldo(dto.getSaldo())
		.tipo(dto.getTipo())
		.fecha(dto.getFecha())
		.cuenta(cuenta)
		.build();
		
	}

}
