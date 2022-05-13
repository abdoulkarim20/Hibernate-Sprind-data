package cours.spring.simplon.myfirstappspringboot.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
/*
* @Data getter et setters
* @NoArgsConstructor constructeur sans argument
* @AllArgsConstructor constructeur avec arguments
* @ToString returne les donnees */
@Entity
@Table(name = "patients")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(length = 200)
    private String nomComplet;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private int score;
    private boolean malade;
}
