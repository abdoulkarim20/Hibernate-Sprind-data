package cours.spring.simplon.myfirstappspringboot;

import cours.spring.simplon.myfirstappspringboot.entities.Patient;
import cours.spring.simplon.myfirstappspringboot.repositories.PatientRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class MyfirstappspringbootApplication implements CommandLineRunner {
    /*Je vais faire l'injection des dependences ici afin que je puise
    * a toutes les methodes que spring me reserve*/
    @Autowired
    private PatientRepositorie patientRepositorie;
    public static void main(String[] args) {
        SpringApplication.run(MyfirstappspringbootApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
//        patientRepositorie.save(new Patient(null,"Abdoul Karim DIALLO", new Date(),234,false));
//        patientRepositorie.save(new Patient(null,"Fatou OULARE", new Date(),24,false));
//        patientRepositorie.save(new Patient(null,"Mariame Lamarana DIALLO", new Date(),34,false));
//        patientRepositorie.save(new Patient(null,"Awoulo Amarou Shakour", new Date(),124,true));

        /*Affichage de tous les patients*/
        System.out.println("*Affichage de tous les patients*");
        patientRepositorie.findAll().forEach(patient -> {
            System.out.println(patient.toString());
        });
        /*Affichage d'un patients par son id*/
        System.out.println("*Affichage d'un patients par son id*");
        Patient patient=patientRepositorie.findById(3L).get();
        System.out.println(patient);
        System.out.println("/*La liste des patient dont leurs nom comtient une lettre specifique*/");
        patientRepositorie.findByNomCompletContains("Aw").forEach(patient1 -> {
            System.out.println(patient1.toString());
        });

        System.out.println("/*La liste des patient malades/");
        patientRepositorie.findByMalade(true).forEach(patient2 ->{
            System.out.println(patient2.toString());
        } );
        System.out.println("/*La liste des patient dont le nom contient une lettre specifique et maladie*/");
        patientRepositorie.findByNomCompletContainsAndMalade("Aw",true)
                .forEach(patient1 -> {
                    System.out.println(patient1.toString());
                });
        //La suppression d'un patient
//        for (int i=0;i<=2;i++){
//            patientRepositorie.save(new Patient(null,"Houley",new Date(),23,false));
//        }
        //supprimer un patient par son id
//        patientRepositorie.deleteById(7L);
//        System.out.println("*Tous les patients*");
//        patientRepositorie.findAll().forEach(patient5 -> {
//            System.out.println(patient5.toString());
//        });
        System.out.println("/*Pagination*/");
        //pagination
        Page<Patient> patientPage=patientRepositorie.findAll(PageRequest.of(3,2));
        List<Patient> patientList=patientPage.getContent();
        patientList.forEach(patient1 -> {
            System.out.println(patient1.toString());
        });

    }
}
