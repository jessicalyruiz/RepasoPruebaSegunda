package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.Matricula;
import ec.edu.uce.modelo.Propietario;
import ec.edu.uce.modelo.Vehiculo;
import ec.edu.uce.modelo.VehiculoLiviano;
import ec.edu.uce.modelo.VehiculoPesado;

import ec.edu.uce.service.IMatriculaService;
import ec.edu.uce.service.IPropietarioService;
import ec.edu.uce.service.IVehiculoService;

@SpringBootApplication
public class RepasoPruebaSegundaApplication implements CommandLineRunner {

	private static final Logger LOG= (Logger) LoggerFactory.getLogger(RepasoPruebaSegundaApplication.class);
	 
	@Autowired IMatriculaService matriService;
	
	@Autowired
	@Qualifier("liviano")
	IVehiculoService vehiculoLService;
	
	@Autowired
	@Qualifier("pesado")
	IVehiculoService vehiculoPService;
	
	@Autowired 
	IPropietarioService propietarioService;
	
	@Autowired 
	IMatriculaService matriculaService;
	
	
	
	public Scanner letras=new Scanner(System.in);
	public Scanner num=new Scanner(System.in);
	
	public static void main(String[] args) {
		SpringApplication.run(RepasoPruebaSegundaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		Matricula matri=new Matricula();
		matri.setNumMatricula(4545);
		matri.setFecha(LocalDateTime.of(2018,5 ,20, 15, 45, 30)); //anio, mes, dia, hora, minuto, segundo
		//LocalDate.of(2014, Month.JANUARY, 1) 
		LocalDateTime miFecha=LocalDateTime.of(2022, Month.FEBRUARY, 5, 12, 45); //anio, mes, dia, hora, minuto,
		
		Matricula matri2=new Matricula();
		matri2.setNumMatricula(8961);
		matri2.setFecha(LocalDateTime.of(2022, Month.DECEMBER, 5, 12, 45));
		
		
		Matricula matri3=new Matricula();
		matri3.setNumMatricula(8961);
		matri3.setFecha(LocalDateTime.of(2022, Month.DECEMBER, 5, 12, 45));
		
		List<Matricula> listaMatriculas=new ArrayList<>();
		listaMatriculas.add(matri2);
		listaMatriculas.add(matri);
		listaMatriculas.add(matri3);
		
		Propietario propietario=new Propietario();
		propietario.setApellido("Sisalima");
		propietario.setNombre("Eufemia");
		propietario.setCedula("17098");
		propietario.setMatricula(listaMatriculas);
		
		matri.setPropietario(propietario);
		matri2.setPropietario(propietario);
		matri3.setPropietario(propietario);
		
		VehiculoLiviano vehiLiviano=new VehiculoLiviano();
		vehiLiviano.setMarca("wols");
		vehiLiviano.setPaisOrigen("alemania" );
		vehiLiviano.setPlaca("ui-7");
		vehiLiviano.setPrecio(new BigDecimal(50000));
		vehiLiviano.setTipo("liviano");
		vehiLiviano.setPropietario(propietario);
		vehiLiviano.setMatricula(matri);
		vehiLiviano.setCilindrajeTurbo(new BigDecimal(45.8));
		
		VehiculoPesado veh=new VehiculoPesado();
		veh.setMarca("chevrolet");
		veh.setPaisOrigen("china" );
		veh.setPlaca("hio-7");
		veh.setPrecio(new BigDecimal(784000));
		veh.setTipo("pesado");
		veh.setPropietario(propietario);
		veh.setMatricula(matri3);
		veh.setPesoToneladas(7896.4f);
		
		
		VehiculoPesado vehiPesado=new VehiculoPesado();
		vehiPesado.setMarca("Mercedes");
		vehiPesado.setPaisOrigen("Alemania");
		vehiPesado.setPlaca("dg-5");
		vehiPesado.setPrecio(new BigDecimal(120000));
		vehiPesado.setPropietario(propietario);
		vehiPesado.setTipo("pesado");
		vehiPesado.setPropietario(propietario);
		vehiPesado.setMatricula(matri2);
		vehiLiviano.setCilindrajeTurbo(new BigDecimal(129.4));
		
		
		List<Vehiculo> listaVehiculos=new ArrayList<>();
		listaVehiculos.add(vehiPesado);
		listaVehiculos.add(vehiLiviano);
		listaVehiculos.add(veh);
		
		//relacion one to many
		propietario.setVehiculos(listaVehiculos);
		
		
		//relacion one to one
		matri.setVehiculo(vehiLiviano);
		matri2.setVehiculo(vehiPesado);
		matri3.setVehiculo(veh);
		
		propietarioService.create(propietario);
		*/
		
		
		/////////////QUERYS*************************
		
		
		//query normal
		Vehiculo v1=this.vehiculoPService.buscarPlaca("dg-5");
		LOG.info(v1.toString());
		
		//typedQuery: si estoy segura del tipo de retorno
		Vehiculo v2=this.vehiculoLService.buscarPlacaTyped("ui-7");
		LOG.info(v2.toString());
		
		//namedQuery: si necesito reutilizarlo
		Vehiculo v3=this.vehiculoPService.buscarPlacaNamed("hio-7");
		LOG.info(v3.toString());
		
		
		//***NAtive
		//para cuando la consulta es mas compleja y quiero ganar rendimiento
		LOG.info("******************nativeQuery");
		Vehiculo v4=this.vehiculoPService.buscarPlacaNative("dg-5");
		LOG.info(v4.toString());
		
		//named native query
		//para cuando tengo una consulta compleja + reutilizable
		LOG.info("******************named nativeQuery");
		Vehiculo v5=this.vehiculoPService.buscarPlacaNamedNative("dg-5");
		LOG.info(v5.toString());
		
		
		//**********Criteria API
		LOG.info("******************CRITERIA");
		Vehiculo v6=this.vehiculoPService.buscarPlacaCriteria("dg-5", "Alemania");
		LOG.info(v6.toString()+"placa "+v6.getPlaca()+"  pais " +v6.getPaisOrigen()  );
		
		
		
		//******Joins
		
		List<Vehiculo> listaVehiculosJOIN=this.vehiculoLService.buscarPropietarioJOIN("Sisalima", new BigDecimal(50));
		LOG.info("*****************fetch**********Longitud"+listaVehiculosJOIN.size());
		for(Vehiculo v: listaVehiculosJOIN) {
			LOG.info(v.toString());
			LOG.info("Propietario: " +v.getPropietario());
		}
		
		
	}

}
