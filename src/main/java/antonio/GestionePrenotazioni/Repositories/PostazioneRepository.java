package antonio.GestionePrenotazioni.Repositories;

import antonio.GestionePrenotazioni.Entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {
}
