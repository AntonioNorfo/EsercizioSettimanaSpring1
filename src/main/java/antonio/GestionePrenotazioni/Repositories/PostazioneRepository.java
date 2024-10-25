package antonio.GestionePrenotazioni.Repositories;

import antonio.GestionePrenotazioni.Entities.Postazione;
import antonio.GestionePrenotazioni.Enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {

    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);

}
