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
public class Group {

    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy="list_group" ,fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<Student> list_students=new HashSet<>();

    private Set<Professor> list_professors=new HashSet<>();
    @ManyToOne
    private Subject subject;





}
