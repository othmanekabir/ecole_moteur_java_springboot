package com.demo.ecole.repositories;

import com.demo.ecole.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professor, String> {

    Professor findByEmail(String email);
    Professor findByEmailAndMotpasse(String email, String motpasse);
}
