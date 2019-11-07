package br.fitinbox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_forma_pagamento")

public class FormaPagamento {
	@Id
	@GeneratedValue
	private int id;
	@Column (nullable=false, length=200)
	private long forma_pagamento;

}
