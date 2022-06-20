package com.demo.ecole.services;

import com.demo.ecole.entities.*;
import com.demo.ecole.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class MyService {

    private EtudiantRepository etudiantRepository;
    private MatiereRepository matiereRepository;
    private ProfesseurRepository professeurRepository;
    private ClasseRepository classeRepository;
    private MatiereEtudiantRepository matiereEtudiantRepository;

    public Student ajouterEtudiant(Student e){
        e.setId(UUID.randomUUID().toString());
        return etudiantRepository.save(e);
    }

    public Matiere ajouterMatiere(Matiere m){
        m.setId(UUID.randomUUID().toString());
        return matiereRepository.save(m);
    }

    public Group ajouterClasse(Group c){
        c.setId(UUID.randomUUID().toString());
        return classeRepository.save(c);
    }

    public Professor ajouterProfesseur(Professor p){
        p.setId(UUID.randomUUID().toString());
        return professeurRepository.save(p);
    }

    public EtudiantMatire ajouterEtudiantMatiere(EtudiantMatire em){
        em.setId(UUID.randomUUID().toString());
        return matiereEtudiantRepository.save(em);
    }


    public void ajouterMatiereToEtudiant(String email, String matiere,double note){
        Student e = etudiantRepository.findByEmail(email);
        Matiere m = matiereRepository.findByNom(matiere);
        EtudiantMatire em = new EtudiantMatire();
        em.setEtudiant(e);
        em.setMatiere(m);
        em.setNote(note);
        EtudiantMatire emm = ajouterEtudiantMatiere(em);
        e.getList_matiere().add(emm);
        m.getList_etudiant().add(emm);

    }

    public void ajouterClasseToEtudiant(String email, String classe){
        Student e = etudiantRepository.findByEmail(email);
        Group c = classeRepository.findByNom(classe);
        e.setClasse(c);
        c.getList_etudiant().add(e);
    }

    public void ajouterMatiereToProfesseur(String email, String matiere){
        Professor p = professeurRepository.findByEmail(email);
        Matiere m = matiereRepository.findByNom(matiere);
        p.getList_matiere().add(m);
        m.getList_professeur().add(p);

    }

    public void ajouterClasseToProfesseur(String email, String classe){
        Professor p = professeurRepository.findByEmail(email);
        Group c = classeRepository.findByNom(classe);
        p.getList_classe().add(c);
        c.getList_professeur().add(p);

    }

    public List<Group> findAllClasses(){
        return classeRepository.findAll();
    }

    public List<Matiere> findAllMatieres(){
        return matiereRepository.findAll();
    }
    public Student findEtudiantByEmail(String email){
        return etudiantRepository.findByEmail(email);
    }
    public List<Student> findAllStudents(){
        return etudiantRepository.findAll();
    }

    public EtudiantMatire findEtudiantMatiereByEtudiantidAndMatiereid(String etudiantid, String matiere){
        Student e = etudiantRepository.findById(etudiantid).get();
        Matiere m = matiereRepository.findByNom(matiere);
        return matiereEtudiantRepository.findByEtudiantAndMatiere(e,m).get(0);


    }

    public Professor findProffesseurByEmail(String email){
        return professeurRepository.findByEmail(email);
    }

    public void updateNoteEtudiantMatiere(String etudiantid, String matiere, String note){
        EtudiantMatire em = findEtudiantMatiereByEtudiantidAndMatiereid(etudiantid,matiere);
        em.setNote(Double.parseDouble(note));
    }

    public void insertIntoEtudiantMatiere(String etudiant, String matiere, String note){
        EtudiantMatire em = new EtudiantMatire();
        em.setId(UUID.randomUUID().toString());
        em.setNote(Double.parseDouble(note));
        Matiere m = matiereRepository.findByNom(matiere);
        em.setMatiere(m);
        String[] nomcomplet = etudiant.split(" ");
        Student e = etudiantRepository.findByNomAndPrenom(nomcomplet[0], nomcomplet[1]);
        em.setEtudiant(e);
        ajouterEtudiantMatiere(em);
    }

    public void deletenote(String idMatiereEtudiant){
        EtudiantMatire em = matiereEtudiantRepository.findById(idMatiereEtudiant).get();
        matiereEtudiantRepository.delete(em);
    }

    public List<Student> findEtudiantsByClasseName(String classeName){
        Group c = classeRepository.findByNom(classeName);
        return etudiantRepository.findByClasse(c);
    }

    public Student findStudentByEmailAndMotpasse(String email, String pass){
        return etudiantRepository.findByEmailAndMotpasse(email,pass);
    }

    public Professor findProfByEmailAndMotpasse(String email, String pass){
        return professeurRepository.findByEmailAndMotpasse(email,pass);
    }
}
