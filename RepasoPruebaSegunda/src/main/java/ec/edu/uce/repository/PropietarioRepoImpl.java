package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Propietario;

@Repository
@Transactional
public class PropietarioRepoImpl implements IPropietarioRepo{

private static final Logger LOG= (Logger) LoggerFactory.getLogger(PropietarioRepoImpl.class);
	
	
	@PersistenceContext
	private EntityManager  entityManager;


	@Override
	public void create(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(propietario);
	}


	@Override
	public Propietario read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Propietario.class, id);
	}


	@Override
	public void update(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(propietario);
	}


	@Override
	public void delete(Integer id) {
		Propietario propiBorar=this.read(id);
		this.entityManager.remove(propiBorar);
	}
}
