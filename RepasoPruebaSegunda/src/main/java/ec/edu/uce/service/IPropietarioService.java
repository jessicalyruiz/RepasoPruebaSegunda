package ec.edu.uce.service;

import ec.edu.uce.modelo.Propietario;

public interface IPropietarioService {

	public void create(Propietario propietario);
	public Propietario read(Integer id); 
	public void update(Propietario propietario); 
	public void delete(Integer id); 
}
