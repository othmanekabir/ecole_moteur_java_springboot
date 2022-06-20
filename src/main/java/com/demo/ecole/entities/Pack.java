package com.demo.ecole.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "packs")
public class Pack {
    @Id
    private String id;
    private String name;
    private String description;
    private double value;
    private double percent;
}
