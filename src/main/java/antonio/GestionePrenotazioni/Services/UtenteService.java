package antonio.GestionePrenotazioni.Services;

import antonio.GestionePrenotazioni.Entities.Utente;
import antonio.GestionePrenotazioni.Repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente salvaUtente(Utente utente) {
        log.info("Salvataggio dell'utente: {}", utente.getUsername());
        return utenteRepository.save(utente);
    }

    public void salvaTuttiGliUtenti(List<Utente> utenti) {
        log.info("Salvataggio di una lista di utenti.");
        utenteRepository.saveAll(utenti);
    }
}
