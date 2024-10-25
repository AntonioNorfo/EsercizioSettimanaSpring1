package antonio.GestionePrenotazioni.Repositories;

import antonio.GestionePrenotazioni.Entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EdificioRepository extends JpaRepository<Edificio, UUID> {

}
