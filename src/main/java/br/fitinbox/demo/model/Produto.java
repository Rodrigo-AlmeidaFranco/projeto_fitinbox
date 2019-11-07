package br.fitinbox.demo.model;

public class Produto {
	private Integer id_produto;
	private String descricao;
	private String nome;
	private String preco;
	private Integer id_tipo;
	private Integer id_volume;
	
	
	
	public Produto() {
		super();
	}
	public Integer getId_produto() {
		return id_produto;
	}
	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public Integer getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(Integer id_tipo) {
		this.id_tipo = id_tipo;
	}
	public Integer getId_volume() {
		return id_volume;
	}
	public void setId_volume(Integer id_volume) {
		this.id_volume = id_volume;
	}
	
	
}
