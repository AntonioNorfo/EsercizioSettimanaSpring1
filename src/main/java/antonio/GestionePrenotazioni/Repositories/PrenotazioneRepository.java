package antonio.GestionePrenotazioni.Repositories;

import antonio.GestionePrenotazioni.Entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {
}