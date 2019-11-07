package br.fitinbox.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.fitinbox.model.Estado;
import br.fitinbox.model.FormaPagamento;

public class EstadoDAO {
	@PersistenceContext
	EntityManager manager;
	public EstadoDAO(EntityManager manager){
		this.manager = manager;
	}
	public void create( Estado estado){
		manager.persist(estado);
	}
	public void update( Estado estado){
		manager.merge(estado);
	}
	public void delete( Estado estado){
		manager.remove(estado);
	}
	public Estado select(int id){
		return manager.find( Estado.class, id);
	}

}
