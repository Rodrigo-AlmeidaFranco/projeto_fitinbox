package br.fitinbox.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.fitinbox.model.Cidade;


public class CidadeDAO {
	@PersistenceContext
	EntityManager manager;
	public CidadeDAO(EntityManager manager){
		this.manager = manager;
	}
	public void create( Cidade cidade){
		manager.persist(cidade);
	}
	public void update( Cidade cidade){
		manager.merge(cidade);
	}
	public void delete( Cidade cidade){
		manager.remove(cidade);
	}
	public Cidade select(int id){
		return manager.find( Cidade.class, id);
	}

}
