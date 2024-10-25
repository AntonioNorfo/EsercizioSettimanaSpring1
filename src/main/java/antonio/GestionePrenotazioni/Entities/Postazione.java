package antonio.GestionePrenotazioni.Entities;


import antonio.GestionePrenotazioni.Enums.TipoPostazione;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "postazioni")

public class Postazione {

    @Id
    @GeneratedValue
    private UUID postazione_id;

    private String descrizione;

    private TipoPostazione tipo;

    private int num_max_occupanti;

    private UUID edificio_id;
}
