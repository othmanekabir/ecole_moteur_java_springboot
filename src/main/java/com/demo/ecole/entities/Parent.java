package com.demo.ecole.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "parents")
public class Parent {
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
    @OneToMany(mappedBy="list_parent" ,fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<Student> list_students = new HashSet<>();

}
