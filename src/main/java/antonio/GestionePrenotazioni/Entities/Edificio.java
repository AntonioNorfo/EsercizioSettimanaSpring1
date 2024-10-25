package antonio.GestionePrenotazioni.Entities;

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
@Table(name = "edifici")
public class Edificio {

    @Id
    @GeneratedValue
    private UUID edificio_id;

    private String nome;

    private String indirizzo;

    private String citta;
}

