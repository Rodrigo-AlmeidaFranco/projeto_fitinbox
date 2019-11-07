package br.fitinbox.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import br.fitinbox.model.Pedido;




public class PedidoDAO {
	@PersistenceContext
	EntityManager manager;
	public PedidoDAO(EntityManager manager){
		this.manager = manager;
	}
	public void create( Pedido pedido){
		manager.persist(pedido);
	}
	public void update( Pedido pedido){
		manager.merge(pedido);
	}
	public void delete( Pedido pedido){
		manager.remove(pedido);
	}
	public Pedido select(int id){
		return manager.find( Pedido.class, id);
	}

}
