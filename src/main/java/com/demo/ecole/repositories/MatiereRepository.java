package com.demo.ecole.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereRepository extends JpaRepository<Matiere, String> {

    Matiere findByNom(String name);
}
