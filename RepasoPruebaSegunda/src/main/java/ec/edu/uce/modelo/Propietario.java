package ec.edu.uce.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="propietario")
public class Propietario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_propietario")
	@SequenceGenerator(name = "seq_propietario", sequenceName = "seq_propietario",allocationSize = 1)
	@Column(name = "prop_id")
	private Integer id;
	
	@Column(name = "prop_nombre")
	private String nombre;
	
	@Column(name = "prop_apellido")
	private String apellido;
	
	@Column(name = "prop_cedula")
	private String cedula;
	
	@OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
	private List<Matricula> matricula;
	
	//un propietario puede tener varios vehiculos
	@OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
	private List<Vehiculo> vehiculos;

	//GET Y SET
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}


	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}


	public List<Matricula> getMatricula() {
		return matricula;
	}


	public void setMatricula(List<Matricula> matricula) {
		this.matricula = matricula;
	}


	@Override
	public String toString() {
		return "Propietario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", vehiculos=" + vehiculos + "]";
	}
	
	
}
