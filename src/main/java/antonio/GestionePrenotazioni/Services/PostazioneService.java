package antonio.GestionePrenotazioni.Services;

import antonio.GestionePrenotazioni.Entities.Postazione;
import antonio.GestionePrenotazioni.Enums.TipoPostazione;
import antonio.GestionePrenotazioni.Repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> cercaPostazioni(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }
}
