package ec.edu.uce.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculo_liviano")
public class VehiculoLiviano extends Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_vehi_liv")
	@SequenceGenerator(name = "seq_vehi_liv", sequenceName = "seq_vehi_liv",allocationSize = 1)
	@Column(name = "vehi_id")
	private Integer id;
	
	@Column(name = "vehi_cilindraje_turbo")
	private BigDecimal cilindrajeTurbo;
	
	@OneToOne
	@JoinColumn(name = "vliviano_fk_matricula" )
	protected Matricula matricula;

	//GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCilindrajeTurbo() {
		return cilindrajeTurbo;
	}

	public void setCilindrajeTurbo(BigDecimal cilindrajeTurbo) {
		this.cilindrajeTurbo = cilindrajeTurbo;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "VehiculoLiviano [id=" + id + ", cilindrajeTurbo=" + cilindrajeTurbo + "]";
	}
	
	
	
}
