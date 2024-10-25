package antonio.GestionePrenotazioni.Entities;

import antonio.GestionePrenotazioni.Enums.TipoPostazione;
import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;

    private int num_max_occupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id", nullable = false)
    private Edificio edificio;

    public Postazione(String descrizione, TipoPostazione tipo, int num_max_occupanti, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.num_max_occupanti = num_max_occupanti;
        this.edificio = edificio;
    }
}
