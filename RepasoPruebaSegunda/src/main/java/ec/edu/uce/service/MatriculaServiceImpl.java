package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Matricula;
import ec.edu.uce.repository.IMatriculaRepo;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired IMatriculaRepo matriRepo;

	@Override
	public void create(Matricula matricula) {
		// TODO Auto-generated method stub
		this.matriRepo.create(matricula);
	}

	@Override
	public Matricula read(Integer id) {
		// TODO Auto-generated method stub
		return this.matriRepo.read(id);
	}

	@Override
	public void update(Matricula matricula) {
		// TODO Auto-generated method stub
		this.matriRepo.update(matricula);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.matriRepo.delete(id);
	}
	
}
