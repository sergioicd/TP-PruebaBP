package com.example.demo.models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "MOVIMIENTO")
public class Movimiento {
	
	@Id
	@Column(name = "ID_MOVIMIENTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMovimiento;
	@Column(name = "FECHA_MOVIMIENTO")
	private LocalDateTime fecha;
	@Column(name = "TIPO_MOVIMIENTO")
	private String tipo;
	@Column(name = "VALOR_MOVIMIENTO")
	private Double valor;
	@Column(name = "SALDO")
	private Double saldo;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_CUENTA_ID")
	private Cuenta cuenta;

}
