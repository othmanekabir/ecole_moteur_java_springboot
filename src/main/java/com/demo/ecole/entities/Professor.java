package com.demo.ecole.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Professor {

    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String postal_code;
    private String adress;
    private String city;
    private String email;
    private String password;
    //@ManyToMany( mappedBy = "list_professeur",fetch = FetchType.EAGER)
    private Set<Group> list_groups= new HashSet<>();



}
