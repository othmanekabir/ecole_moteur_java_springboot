package com.demo.ecole.controllers;

import com.demo.ecole.entities.Student;
import com.demo.ecole.entities.Professor;
import com.demo.ecole.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private MyService myService;

     @GetMapping("/etudiant/{email}")
     Student getEtudiantById(@PathVariable String email) {

        return myService.findEtudiantByEmail(email);
    }

    @GetMapping("/authentification/student/{email}/{password}")
    Student authentificationStudent(@PathVariable String email, @PathVariable String password) {

        return myService.findStudentByEmailAndMotpasse(email,password);
    }

    @GetMapping("/authentification/prof/{email}/{password}")
    Professor authentificationProf(@PathVariable String email, @PathVariable String password) {

        return myService.findProfByEmailAndMotpasse(email,password);
    }

    @GetMapping("/etudiants")
    List<Student> getEtudiants() {

        return myService.findAllStudents();
    }

    @GetMapping("/etudiants/classes/{classeName}")
    List<Student> getclasses(@PathVariable String classeName) {

        return myService.findEtudiantsByClasseName(classeName);
    }

    @GetMapping("/classes")
    List<String> getclasses() {

        return myService.findAllClasses().stream().map(c -> c.getNom()).collect(Collectors.toList());
    }

    @GetMapping("/matieres")
    List<String> getmatieres() {

        return myService.findAllMatieres().stream().map(m -> m.getNom()).collect(Collectors.toList());
    }

    @PutMapping("/updatestudentnote/{id}/{matiere}/{note}")
    void updateStudentNote(@PathVariable String id, @PathVariable String matiere, @PathVariable String note) {

        myService.updateNoteEtudiantMatiere(id,matiere,note);
    }

    @PutMapping("/addstudentnote/{nomcomplet}/{matiere}/{note}")
    void addStudentNote(@PathVariable String nomcomplet, @PathVariable String matiere, @PathVariable String note) {

        myService.insertIntoEtudiantMatiere(nomcomplet,matiere,note);
    }

    @DeleteMapping("/deletestudentnote/{idEtidiantMatiere}")
    void deleteStudentNote(@PathVariable String idEtidiantMatiere) {
        myService.deletenote(idEtidiantMatiere);
    }



}
