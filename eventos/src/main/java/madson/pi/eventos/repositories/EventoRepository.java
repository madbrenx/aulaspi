package madson.pi.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import madson.pi.eventos.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
