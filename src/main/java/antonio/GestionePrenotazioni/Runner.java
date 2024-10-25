package antonio.GestionePrenotazioni;

import antonio.GestionePrenotazioni.Entities.Edificio;
import antonio.GestionePrenotazioni.Entities.Postazione;
import antonio.GestionePrenotazioni.Entities.Utente;
import antonio.GestionePrenotazioni.Enums.TipoPostazione;
import antonio.GestionePrenotazioni.Repositories.EdificioRepository;
import antonio.GestionePrenotazioni.Services.PostazioneService;
import antonio.GestionePrenotazioni.Services.PrenotazioneService;
import antonio.GestionePrenotazioni.Services.UtenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@Slf4j
public class Runner implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {

        List<Edificio> edifici = Arrays.asList(
                new Edificio("One Piece", "iMissYou 1", "Palermo"),
                new Edificio("HuecoMundo", "PlsTogheter 5", "Giappone"),
                new Edificio("TorreDiBalzar", "Paradise 3", "Svizzera"),
                new Edificio("EsprimiDesiderio", "Other World 2", "Interlaken"),
                new Edificio("STanzaDelloSpiritoEdelTempo", "Via Heaven 5", "Norvegia")
        );
        edifici.forEach(edificioRepository::save);

        List<Utente> utenti = Arrays.asList(
                new Utente("Melodias", "Escanor", "Escanor.deadly@gmail.com"),
                new Utente("Gohan", "Goku", "GokuNonLoSai@gmail.com"),
                new Utente("Light", "SfereDelDrago", "drago.miss@uforever.com"),
                new Utente("Pain", "PrincipeDeiSayan", "Vegeta@gmail.com"),
                new Utente("Naruto", "Ichigo", "Bleach@fighissimo.com"),
                new Utente("Trunks", "Monkey D.Luffy", "TheKing@ofTheSea.com")

        );
        utenti.forEach(utenteService::salvaUtente);

        Random random = new Random();
        for (Edificio edificio : edifici) {
            for (int i = 0; i < 5; i++) {
                Postazione postazione = new Postazione();
                postazione.setDescrizione("Postazione " + (i + 1) + " - " + edificio.getNome());
                postazione.setTipo(TipoPostazione.values()[random.nextInt(TipoPostazione.values().length)]);
                postazione.setNum_max_occupanti(random.nextInt(5) + 1);
                postazione.setEdificio(edificio);
                postazioneService.salvaPostazione(postazione);
            }
        }

        LocalDate startDate = LocalDate.now().plusDays(1);
        for (Utente utente : utenti) {
            for (int i = 0; i < 3; i++) {
                List<Postazione> postazioni = postazioneService.cercaPostazioni(
                        TipoPostazione.values()[random.nextInt(TipoPostazione.values().length)],
                        edifici.get(random.nextInt(edifici.size())).getCitta()
                );

                if (!postazioni.isEmpty()) {
                    Postazione postazione = postazioni.get(0);
                    LocalDate dataPrenotazione = startDate.plusDays(i);

                    try {
                        prenotazioneService.prenotaPostazione(utente, postazione, dataPrenotazione);
                        log.info("Prenotazione creata per {} alla data {} per postazione {}",
                                utente.getUsername(), dataPrenotazione, postazione.getDescrizione());
                    } catch (Exception e) {
                        log.error("Errore durante la prenotazione: {}", e.getMessage());
                    }
                }
            }
        }
    }
}