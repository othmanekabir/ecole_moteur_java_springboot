package com.demo.ecole.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "student_id")
    private String id;
    private String first_name;
    private String last_name;
    private String postal_code;
    private String adress;
    private String city;
    private String email;
    private String password;

    @OneToMany(mappedBy="list_students" ,fetch = FetchType.EAGER)
    private Set<Group> list_group= new HashSet<>();
    @OneToMany(mappedBy="list_students" ,fetch = FetchType.EAGER)
    private Set<Parent> list_parent= new HashSet<>();
    private Pack pack;




}
