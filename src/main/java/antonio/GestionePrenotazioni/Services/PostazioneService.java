package antonio.GestionePrenotazioni.Services;

import antonio.GestionePrenotazioni.Entities.Postazione;
import antonio.GestionePrenotazioni.Enums.TipoPostazione;
import antonio.GestionePrenotazioni.Repositories.PostazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> cercaPostazioni(TipoPostazione tipo, String citta) {
        log.info("Ricerca postazioni per tipo: {} e città: {}", tipo, citta);
        List<Postazione> postazioni = postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
        log.info("Numero di postazioni trovate: {}", postazioni.size());
        return postazioni;
    }
}
