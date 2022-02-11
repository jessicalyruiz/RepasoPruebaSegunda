package ec.edu.uce.modelo;

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
@Table(name = "vehiculo_pesado")
public class VehiculoPesado extends Vehiculo{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_vehi_pes")
	@SequenceGenerator(name = "seq_vehi_pes", sequenceName = "seq_vehi_pes",allocationSize = 1)
	@Column(name = "vehi_id")
	private Integer id;
	
	@Column(name = "vehi_pesoToneladas")
	private float pesoToneladas;

	@OneToOne
	@JoinColumn(name = "vpesado_fk_matricula" )
	protected Matricula matricula;
	
	//GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getPesoToneladas() {
		return pesoToneladas;
	}

	public void setPesoToneladas(float pesoToneladas) {
		this.pesoToneladas = pesoToneladas;
	}

	
	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "VehiculoPesado [id=" + id + ", pesoToneladas=" + pesoToneladas + "]";
	}
	
	
}
