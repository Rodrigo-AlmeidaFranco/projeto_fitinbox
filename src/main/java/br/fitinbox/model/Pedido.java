package br.fitinbox.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "tb_pedido")
@Getter
@Setter
@ToString


public class Pedido  {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name="cliente_id")
	private Cliente cliente;
	

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name="endereco_id")
	private Endereco endereco;
		

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name="volume_id")
	private Volume volume;
	
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name="id_produto")
	private Produto produto;
	
	@Column (nullable=false, length=100)
	private Long forma_pagamento_id;
}
