package antonio.GestionePrenotazioni.Repositories;

import antonio.GestionePrenotazioni.Entities.Postazione;
import antonio.GestionePrenotazioni.Entities.Prenotazione;
import antonio.GestionePrenotazioni.Entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;


public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {

    boolean existsByUtenteAndData(Utente utente, LocalDate data);

    boolean existsByPostazioneAndData(Postazione postazione, LocalDate data);

}
