package ma.enset.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.backend.model.Genre;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String imageUrl;
    private Date dateNaissance;
    private Genre genre;
    private boolean enRegle;
}
