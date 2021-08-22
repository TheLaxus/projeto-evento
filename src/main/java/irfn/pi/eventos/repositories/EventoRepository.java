package irfn.pi.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import irfn.pi.eventos.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
	
	
}
