package ec.edu.uce.repository;

import ec.edu.uce.modelo.Propietario;

public interface IPropietarioRepo {

	public void create(Propietario propietario);
	public Propietario read(Integer id); 
	public void update(Propietario propietario); 
	public void delete(Integer id); 
}
