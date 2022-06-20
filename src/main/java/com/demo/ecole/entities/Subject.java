package com.demo.ecole.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "subjects")
public class Subject {
    @Id
    @Column(name = "subject_id")
    private String id;
    private String name;
    private String description;
    @OneToMany( mappedBy = "subject",fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private List<Group> list_group;
}
