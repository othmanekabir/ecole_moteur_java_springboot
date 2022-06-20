package com.demo.ecole.repositories;

import com.demo.ecole.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MatiereEtudiantRepository extends JpaRepository<EtudiantMatire, String> {

    List<EtudiantMatire> findByEtudiantAndMatiere(Student e, Matiere m);

   Set<EtudiantMatire> findByEtudiant(Student e);

    Set<EtudiantMatire> findByMatiere(Matiere m);


}
