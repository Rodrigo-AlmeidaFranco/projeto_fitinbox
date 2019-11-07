package br.fitinbox.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.fitinbox.model.Produto;
import br.fitinbox.model.Volume;

public class ProdutoDAO {
	@PersistenceContext
	EntityManager manager;
	public ProdutoDAO(EntityManager manager){
		this.manager = manager;
	}
	public void create( Produto produto){
		manager.persist(produto);
	}
	public void update( Produto produto){
		manager.merge(produto);
	}
	public void delete( Produto produto){
		manager.remove(produto);
	}
	public Produto select(int id){
		return manager.find( Produto.class, id);
	}
}


