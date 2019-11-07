package br.fitinbox.demo.model;

public class Pedido extends Produto{
	private Integer id_pedido;
	private Integer id_cliente;
	private Integer id_endereco;
	private Integer id_formaPagto;
	private Integer id_produto;
	private Integer id_volume;
	private boolean status;
	private String endereco;
	
	
	
	
	
	public Pedido() {
		super();
	}
	public Integer getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}
	public Integer getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}
	public Integer getId_endereco() {
		return id_endereco;
	}
	public void setId_endereco(Integer id_endereco) {
		this.id_endereco = id_endereco;
	}
	public Integer getId_formaPagto() {
		return id_formaPagto;
	}
	public void setId_formaPagto(Integer id_formaPagto) {
		this.id_formaPagto = id_formaPagto;
	}
	public Integer getId_produto() {
		return id_produto;
	}
	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}
	public Integer getId_volume() {
		return id_volume;
	}
	public void setId_volume(Integer id_volume) {
		this.id_volume = id_volume;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
