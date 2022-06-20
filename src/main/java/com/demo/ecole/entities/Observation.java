package com.demo.ecole.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Observations")
public class Observation {
    @Id
    private int id;
    private LocalDate observation_date;
    private boolean presence;
    private int attitude;
    private int contribution;
    private int comprehension;
}
