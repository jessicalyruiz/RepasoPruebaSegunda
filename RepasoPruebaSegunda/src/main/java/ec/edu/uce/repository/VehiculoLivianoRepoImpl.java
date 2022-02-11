package ec.edu.uce.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Vehiculo;

@Repository
@Qualifier("liviano")
@Transactional
public class VehiculoLivianoRepoImpl implements IVehiculoRepo {

	private static final Logger LOG = (Logger) LoggerFactory.getLogger(VehiculoLivianoRepoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vehiculo);
	}

	@Override
	public Vehiculo read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Vehiculo.class, id);
	}

	@Override
	public void update(Vehiculo vehiculo) {
		this.entityManager.merge(vehiculo);
	}

	@Override
	public void delete(Integer id) {
		Vehiculo vehiculoBorrar = this.read(id);
		this.entityManager.remove(vehiculoBorrar);
	}

	@Override
	public Vehiculo buscarPlaca(String placa) {
		Query myQuiery = this.entityManager.createQuery("Select v from Vehiculo v where v.placa =:valor");
		myQuiery.setParameter("valor", placa);

		return (Vehiculo) myQuiery.getSingleResult();
	}

	@Override
	public Vehiculo buscarPlacaTyped(String placa) {
		TypedQuery<Vehiculo> myQuery = (TypedQuery<Vehiculo>) this.entityManager.createQuery("Select v from Vehiculo v where v.placa =:valor");
		myQuery.setParameter("valor", placa);

		return myQuery.getSingleResult();
	}

	@Override
	public Vehiculo buscarPlacaNamed(String placa) {
		Query myQuery = this.entityManager.createNamedQuery("Vehiculo.buscarPlacaNamed");
		myQuery.setParameter("valor", placa);

		return (Vehiculo) myQuery.getSingleResult();
	}

	@Override
	public Vehiculo buscarPlacaNative(String placa) {
		Query myQuery=this.entityManager.createNativeQuery("Select * from vehiculo v where v.vehi_placa=:valor",Vehiculo.class);
		myQuery.setParameter("valor", placa);

		return (Vehiculo) myQuery.getSingleResult();
	}

	@Override
	public Vehiculo buscarPlacaNamedNative(String placa) {
		Query myQuery = this.entityManager.createNamedQuery("Vehiculo.buscarPlacaNamedNative");
		myQuery.setParameter("valor", placa);

		return (Vehiculo) myQuery.getSingleResult();
	}

	@Override
	public Vehiculo buscarPlacaCriteria(String placa, String pais) {
				//1.- especifico el tipo de query
				CriteriaBuilder miCriteria=this.entityManager.getCriteriaBuilder();
				//2. especifico el tipo de retorno
				CriteriaQuery<Vehiculo> miQuery=miCriteria.createQuery(Vehiculo.class);
				//empezar a contruir el SQL
				//3.- defino el objeto que va a representar la tabla
				Root<Vehiculo> miTabla=miQuery.from(Vehiculo.class);
				//4.-Creo los predicados, que son los "where" de criteria API
				Predicate p1=miCriteria.equal(miTabla.get("placa"), placa);
				Predicate p2=miCriteria.equal(miTabla.get("paisOrigen"), pais);
						//uno los predicados
				Predicate predicadoFinal=miCriteria.or(p1,p2);
				
				//5.-Armo el Query
				miQuery.select(miTabla).where(predicadoFinal);
				//6.-creo un Typed Query
				TypedQuery<Vehiculo> typedQuery=this.entityManager.createQuery(miQuery);
				
				return typedQuery.getSingleResult();
				
	}

	@Override
	public List<Vehiculo> buscarPropietarioJOIN(String apellido, BigDecimal precio) {
		TypedQuery<Vehiculo> myQuery=this.entityManager.createQuery("SELECT v FROM Vehiculo v JOIN FETCH v.propietario p WHERE v.precio>=:precio AND p.apellido=:apellido", Vehiculo.class);
		myQuery.setParameter("apellido", apellido);
		myQuery.setParameter("precio", precio);
		return myQuery.getResultList();
	}
}
