package ec.edu.uce.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity

@Table(name = "vehiculo")
@NamedQuery(name = "Vehiculo.buscarPlacaNamed", query = "Select v from Vehiculo v where v.placa=:valor")
@NamedNativeQuery(name = "Vehiculo.buscarPlacaNamedNative", query = "Select * from vehiculo v where v.vehi_placa=:valor", resultClass = Vehiculo.class)
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_vehi")
	@SequenceGenerator(name = "seq_vehi", sequenceName = "seq_vehi",allocationSize = 1)
	@Column(name = "vehi_id")
	protected Integer id;
	
	@Column(name = "vehi_marca")
	protected String marca;
	
	@Column(name = "vehi_pais_origen")
	protected String paisOrigen;
	
	@Column(name = "vehi_placa")
	protected String placa;
	
	@Column(name = "vehi_tipo")
	protected String tipo;
	
	@Column(name = "vehi_precio")
	protected BigDecimal precio;
	
	@ManyToOne
	@JoinColumn(name = "prop_id")
	protected Propietario propietario;
	
	
	@OneToOne
	@JoinColumn(name = "vehi_fk_matricula" )
	protected Matricula matricula;

	
	//get y set
	public Integer getId() {
		return id;
	}

	

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}


	
	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", marca=" + marca + ", paisOrigen=" + paisOrigen + ", placa=" + placa + ", tipo="
				+ tipo + ", precio=" + precio + ", propietario=" + propietario  + "]";
	}
}
