package antonio.GestionePrenotazioni.Services;

import antonio.GestionePrenotazioni.Entities.Postazione;
import antonio.GestionePrenotazioni.Entities.Prenotazione;
import antonio.GestionePrenotazioni.Entities.Utente;
import antonio.GestionePrenotazioni.Exception.PostazioneNonDisponibileException;
import antonio.GestionePrenotazioni.Exception.PrenotazioneDuplicataException;
import antonio.GestionePrenotazioni.Repositories.PrenotazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione prenotaPostazione(Utente utente, Postazione postazione, LocalDate data) {
        log.info("Tentativo di prenotazione per utente: {}, postazione: {}, data: {}", utente.getUsername(), postazione.getDescrizione(), data);


        if (prenotazioneRepository.existsByUtenteAndData(utente, data)) {
            throw new PrenotazioneDuplicataException("L'utente ha già una prenotazione per questa data");
        }

        if (prenotazioneRepository.existsByPostazioneAndData(postazione, data)) {
            throw new PostazioneNonDisponibileException("La postazione non è disponibile per questa data");
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione);
        prenotazione.setData(data);

        Prenotazione prenotazioneSalvata = prenotazioneRepository.save(prenotazione);
        log.info("Prenotazione confermata per utente: {}, postazione: {}, data: {}", utente.getUsername(), postazione.getDescrizione(), data);

        return prenotazioneSalvata;
    }
}
