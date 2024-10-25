package antonio.GestionePrenotazioni.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString


@Entity
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue
    private UUID prenotazione_id;

    private LocalDate data;

    private UUID utente_id;

    private UUID postazione_id;

}
