package ma.enset.jpaap.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@Data //lombok qui va ajouter les getters() et setters()
@NoArgsConstructor //lombok qui va ajouter le constructeur sans params
@AllArgsConstructor//lombok qui va ajouter le constructeur avec params
@ToString // generate toString()
@Entity // Entité Patient

public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // clé primaire
    private Long id;
    @Column(length = 50)
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dn;
    private boolean malade;
    private int score;

}
