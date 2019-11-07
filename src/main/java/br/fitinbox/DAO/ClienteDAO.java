package br.fitinbox.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.fitinbox.model.Cliente;


public class ClienteDAO {
	@PersistenceContext
	EntityManager manager;
	public ClienteDAO(EntityManager manager){
		this.manager = manager;
	}
	public void create( Cliente cliente){
		manager.persist(cliente);
	}
	public void update( Cliente cliente){
		manager.merge(cliente);
	}
	public void delete( Cliente cliente){
		manager.remove(cliente);
	}
	public Cliente select(int id){
		return manager.find( Cliente.class, id);
	}

}
