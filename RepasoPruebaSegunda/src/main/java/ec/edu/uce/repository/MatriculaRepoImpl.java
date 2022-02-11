package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Matricula;



@Repository
@Transactional
public class MatriculaRepoImpl implements IMatriculaRepo{

	private static final Logger LOG= (Logger) LoggerFactory.getLogger(MatriculaRepoImpl.class);
	
	
	@PersistenceContext
	private EntityManager  entityManager;


	@Override
	public void create(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}


	@Override
	public Matricula read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Matricula.class, id);
	}


	@Override
	public void update(Matricula matricula) {
		this.entityManager.merge(matricula);
	}


	@Override
	public void delete(Integer id) {
		Matricula matriBorrar=this.read(id);
		this.entityManager.remove(matriBorrar);
	}
}
