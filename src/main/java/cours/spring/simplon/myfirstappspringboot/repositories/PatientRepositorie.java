package cours.spring.simplon.myfirstappspringboot.repositories;

import cours.spring.simplon.myfirstappspringboot.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepositorie extends JpaRepository<Patient,Long> {
    //ici je declare mes propres methodes
    public List<Patient> findByNomCompletContains(String parametre);
    public List<Patient> findByMalade(boolean parametre);
    public List<Patient> findByNomCompletContainsAndMalade(String parametre,boolean malade);
}
