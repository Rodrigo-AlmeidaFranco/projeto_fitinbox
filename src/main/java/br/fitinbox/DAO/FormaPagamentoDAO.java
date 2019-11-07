package br.fitinbox.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.fitinbox.model.FormaPagamento;
import br.fitinbox.model.Pedido;

public class FormaPagamentoDAO {
	@PersistenceContext
	EntityManager manager;
	public FormaPagamentoDAO(EntityManager manager){
		this.manager = manager;
	}
	public void create( FormaPagamento formapagamento){
		manager.persist(formapagamento);
	}
	public void update( FormaPagamento formapagamento){
		manager.merge(formapagamento);
	}
	public void delete( FormaPagamento formapagamento){
		manager.remove(formapagamento);
	}
	public FormaPagamento select(int id){
		return manager.find( FormaPagamento.class, id);
	}

}
