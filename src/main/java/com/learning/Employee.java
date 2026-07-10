package com.learning;



import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMPLOYEE_DATA")
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    @Basic
    private String name;

    @Enumerated(EnumType.STRING)
    private Roles role;

    
    private LocalDate birthDate;

    @Transient
    protected Integer age;

    @OneToOne(mappedBy = "employee")
    private AccessCard accessCard;

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", role: " + role + ", birthDate: " + birthDate;
    }
}
