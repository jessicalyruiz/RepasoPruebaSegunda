package ec.edu.uce.service;


import java.math.BigDecimal;
import java.util.List;

import ec.edu.uce.modelo.Vehiculo;

public interface IVehiculoService {

	public void create(Vehiculo vehiculo);
	public Vehiculo read(Integer id); 
	public void update(Vehiculo vehiculo); 
	public void delete(Integer id); 
	
	//*********Querys
		//query normal
		public Vehiculo buscarPlaca(String placa);
		//typedQuery: si estoy segura del tipo de retorno
		public Vehiculo buscarPlacaTyped(String placa);
		
		//namedQuery: si necesito reutilizarlo
		public Vehiculo buscarPlacaNamed(String placa);
		
		
		//***nativeQuery
		// para cuando la consulta es mas compleja y quiero ganar rendimiento
		public Vehiculo buscarPlacaNative(String placa);
		
		//named native query
		//para cuando tengo una consulta compleja + reutilizable
		public Vehiculo buscarPlacaNamedNative(String placa);
		
		
		//*****criteria API
		//
		public Vehiculo buscarPlacaCriteria(String placa, String pais);
		
		//*********Joins
		public List<Vehiculo> buscarPropietarioJOIN(String apellido, BigDecimal precio);
}
