package com.demo.ecole.repositories;

import com.demo.ecole.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasseRepository extends JpaRepository<Group, String> {

    Group findByNom(String name);

}
