package antonio.GestionePrenotazioni.Repositories;

import antonio.GestionePrenotazioni.Entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UtenteRepository extends JpaRepository<Utente, UUID> {

    List<Utente> findByUsername(String username);
}
