package br.fitinbox.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_endereco")

public class Endereco {
	@Id
	@GeneratedValue
	private Long id;
	@Column (nullable=false, length=200)
	private String logradouro;
	@Column (nullable=false, length=5)
	private String numero;
	
	@OneToMany (mappedBy= "endereco")
	private List<Pedido> pedido;
	
	@OneToMany (mappedBy= "endereco")
	private List<Cidade> cidade;
	
	@OneToMany (mappedBy= "endereco")
	private List<Estado> estado;
	
	

}
