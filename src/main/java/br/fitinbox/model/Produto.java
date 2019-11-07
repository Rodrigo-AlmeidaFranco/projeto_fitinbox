package br.fitinbox.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "tb_produto")
@Setter @Getter @ToString
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column (nullable=false, length=200)
	private String descricao;
	@Column (nullable=false, length=200)
	private String nome;
	@Column (nullable=false, length=200)
	private String preco;
	
	@OneToMany (mappedBy= "produto")
	private List <Pedido> pedidos;
	
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name="id_volume")
	private Volume volume;


}
