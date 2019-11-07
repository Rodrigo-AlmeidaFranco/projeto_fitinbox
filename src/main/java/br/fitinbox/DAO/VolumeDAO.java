package br.fitinbox.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.fitinbox.model.Volume;

public class VolumeDAO {

	@PersistenceContext
	EntityManager manager;
	public VolumeDAO(EntityManager manager){
		this.manager = manager;
	}
	public void create( Volume volume){
		manager.persist(volume);
	}
	public void update( Volume volume){
		manager.merge(volume);
	}
	public void delete( Volume volume){
		manager.remove(volume);
	}
	public Volume select(int id){
		return manager.find( Volume.class, id);
	}
}
