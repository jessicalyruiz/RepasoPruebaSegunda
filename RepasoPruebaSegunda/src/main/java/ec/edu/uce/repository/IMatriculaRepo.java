package ec.edu.uce.repository;

import ec.edu.uce.modelo.Matricula;

public interface IMatriculaRepo {

	public void create(Matricula matricula);
	public Matricula read(Integer id); 
	public void update(Matricula matricula); 
	public void delete(Integer id); 
	
	//Joins
	
	
	
}
