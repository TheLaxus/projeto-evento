package irfn.pi.eventos.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity //vai criar tabela

public class Evento {
	@Getter
	@Setter
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //gerar id automatico
	private Long id;
	private String nome;
	private String local;
	private String data;
	private String horario;
	

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nome=" + nome + ", local=" + local + ", data=" + data + ", horario=" + horario
				+ "]";
	}
	
	

}
