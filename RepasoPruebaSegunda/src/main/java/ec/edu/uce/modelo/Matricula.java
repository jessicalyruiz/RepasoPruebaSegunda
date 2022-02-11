package ec.edu.uce.modelo;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "matricula_Vehiculo")
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_matri_vehi")
	@SequenceGenerator(name = "seq_matri_vehi", sequenceName = "seq_matri_vehi",allocationSize = 1)
	@Column(name = "matr_id")
	private Integer id;
	
	/*
	@ElementCollection //crea un tabla ligera relacionada a cliente con un unico dato
	private List<String> telefonos;
	*/
	
	
	@ManyToOne
	@JoinColumn(name = "matr_fk_propietario")
	private Propietario propietario;
	
	@Column(name = "matr_num")
	private Integer numMatricula;
	
	@Column(name = "matri_fecha", columnDefinition = "TIMESTAMP")
	private LocalDateTime fecha;
	
	@OneToOne(mappedBy = "matricula", cascade = CascadeType.ALL)
	private Vehiculo vehiculo;

	//GET Y SET

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Propietario getPropietario() {
		return propietario;
	}


	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}


	public Integer getNumMatricula() {
		return numMatricula;
	}


	public void setNumMatricula(Integer numMatricula) {
		this.numMatricula = numMatricula;
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	

	public LocalDateTime getFecha() {
		return fecha;
	}


	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "Matricula [id=" + id + ", propietario=" + propietario + ", numMatricula=" + numMatricula + ", vehiculo="
				+ vehiculo + "]";
	}
	
	
	
}
