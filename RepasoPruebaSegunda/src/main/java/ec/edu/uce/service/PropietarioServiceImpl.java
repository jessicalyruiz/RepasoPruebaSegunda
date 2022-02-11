package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Propietario;
import ec.edu.uce.repository.IPropietarioRepo;

@Service
public class PropietarioServiceImpl implements IPropietarioService{

	@Autowired IPropietarioRepo propieRepo;

	@Override
	public void create(Propietario propietario) {
		// TODO Auto-generated method stub
		this.propieRepo.create(propietario);
	}

	@Override
	public Propietario read(Integer id) {
		// TODO Auto-generated method stub
		return this.propieRepo.read(id);
	}

	@Override
	public void update(Propietario propietario) {
		// TODO Auto-generated method stub
		this.propieRepo.update(propietario);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.propieRepo.delete(id);
	}
	
}
