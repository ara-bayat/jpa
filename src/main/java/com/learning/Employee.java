package com.learning;


import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMPLOYEE_DATA")
public class Employee {
    @Id
    private int id;
    @Basic
    private String name;
}
