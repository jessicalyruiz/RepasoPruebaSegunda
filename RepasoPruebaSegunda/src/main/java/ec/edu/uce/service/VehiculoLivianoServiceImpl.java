package ec.edu.uce.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Vehiculo;
import ec.edu.uce.repository.IVehiculoRepo;
import ec.edu.uce.repository.MatriculaRepoImpl;

@Service
@Qualifier("liviano")
public class VehiculoLivianoServiceImpl implements IVehiculoService{

	@Autowired 
	@Qualifier("liviano")
	IVehiculoRepo vehiRepo;

	@Override
	public void create(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.vehiRepo.create(vehiculo);
	}

	@Override
	public Vehiculo read(Integer id) {
		// TODO Auto-generated method stub
		return this.vehiRepo.read(id);
	}

	@Override
	public void update(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.vehiRepo.update(vehiculo);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.vehiRepo.delete(id);
	}

	@Override
	public Vehiculo buscarPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.vehiRepo.buscarPlaca(placa);
	}

	@Override
	public Vehiculo buscarPlacaTyped(String placa) {
		// TODO Auto-generated method stub
		return this.vehiRepo.buscarPlacaTyped(placa);
	}

	@Override
	public Vehiculo buscarPlacaNamed(String placa) {
		// TODO Auto-generated method stub
		return this.vehiRepo.buscarPlacaNamed(placa);
	}

	@Override
	public Vehiculo buscarPlacaNative(String placa) {
		// TODO Auto-generated method stub
		return this.vehiRepo.buscarPlacaNative(placa);
	}

	@Override
	public Vehiculo buscarPlacaNamedNative(String placa) {
		// TODO Auto-generated method stub
		return this.vehiRepo.buscarPlacaNamedNative(placa);
	}

	@Override
	public Vehiculo buscarPlacaCriteria(String placa, String pais) {
		// TODO Auto-generated method stub
		return this.vehiRepo.buscarPlacaCriteria(placa, pais);
	}

	@Override
	public List<Vehiculo> buscarPropietarioJOIN(String apellido, BigDecimal precio) {
		// TODO Auto-generated method stub
		return this.vehiRepo.buscarPropietarioJOIN(apellido, precio);
	} 

}
