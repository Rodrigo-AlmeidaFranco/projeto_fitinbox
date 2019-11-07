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

@Getter
@Setter
@Entity
@Table(name = "tb_estado")
public class Estado {
	@Id
	@GeneratedValue
	private Long id;
	@Column (nullable=false, length=200)
	private String uf;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name="endereco_id")
	private Endereco endereco;
}
