package irfn.pi.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import irfn.pi.eventos.models.Convidado;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long>{
	
	
}
