package com.example.demo.models;

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
@Table(name = "CUENTA")
public class Cuenta {
	
	@Id
	@Column(name = "ID_CUENTA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cuentaId;
	@Column(name = "NUMERO_CUENTA")
	private String numero;
	@Column(name = "TIPO_CUENTA")
	private String tipo;
	@Column(name = "SALDO_INICIAL_CUENTA")
	private Long saldoInicial;
	@Column(name = "ESTADO_CUENTA")
	private Boolean estado;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_CLIENTE_ID")
	private Cliente cliente;

}
