package ec.edu.uce.service;

import ec.edu.uce.modelo.Matricula;

public interface IMatriculaService {

	public void create(Matricula matricula);
	public Matricula read(Integer id); 
	public void update(Matricula matricula); 
	public void delete(Integer id); 
}
