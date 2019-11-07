package br.fitinbox.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.fitinbox.model.Endereco;


public class EnderecoDAO {
	@PersistenceContext
	EntityManager manager;
	public EnderecoDAO(EntityManager manager){
		this.manager = manager;
	}
	public void create( Endereco endereco){
		manager.persist(endereco);
	}
	public void update( Endereco endereco){
		manager.merge(endereco);
	}
	public void delete( Endereco endereco){
		manager.remove(endereco);
	}
	public Endereco select(int id){
		return manager.find( Endereco.class, id);
	}

}
