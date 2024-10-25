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
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue
    private UUID utente_id;

    private String username;

    private String nomeCompleto;

    private String email;

}
