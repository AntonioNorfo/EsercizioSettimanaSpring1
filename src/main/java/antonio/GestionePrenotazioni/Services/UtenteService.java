package antonio.GestionePrenotazioni.Services;

import antonio.GestionePrenotazioni.Entities.Utente;
import antonio.GestionePrenotazioni.Repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente findById(UUID id) {
        return utenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
    }

    public Utente save(Utente utente) {
        return utenteRepository.save(utente);
    }
}
