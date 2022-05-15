package cours.spring.simplon.myfirstappspringboot.web;

import cours.spring.simplon.myfirstappspringboot.entities.Patient;
import cours.spring.simplon.myfirstappspringboot.repositories.PatientRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PatientController {
    @Autowired
    private PatientRepositorie patientRepositorie;
    @GetMapping("/patients")
    public List<Patient> getAll(){
        return patientRepositorie.findAll();
    }
    @GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable Long id){
        return patientRepositorie.findById(id).get();
    }
}
