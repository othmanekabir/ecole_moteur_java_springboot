package com.demo.ecole.repositories;

import com.demo.ecole.entities.Group;
import com.demo.ecole.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Student, String> {

    Student findByEmail(String email);
    List<Student> findByClasse(Group classeName);
    Student findByNomAndPrenom(String nom, String prenom);
    Student findByEmailAndMotpasse(String email, String motpasse);
}
