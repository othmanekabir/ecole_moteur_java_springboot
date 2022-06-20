package com.demo.ecole.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "payments")
public class Payment {

    private String id;
    private LocalDate payment_date;

}
