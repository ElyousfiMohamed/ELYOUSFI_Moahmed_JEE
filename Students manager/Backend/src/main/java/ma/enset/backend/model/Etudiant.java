package ma.enset.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import javax.persistence.*;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    @Size(min = 3,max = 25)
    private String nom;
    @Size(min = 3,max = 25)
    private String prenom;
    private String email;
    private String imageUrl;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_naissance")
    private Date dateNaissance;
    private Genre genre;
    private boolean enRegle;
}
