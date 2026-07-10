package com.learning;



import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
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

    @OneToOne
    @JoinColumn(name = "access_card_id")
    private AccessCard accessCard;

    @OneToMany(mappedBy = "employee")
    private List<Payment> payments;

    @ManyToMany(mappedBy = "employees")
    private List<EmailGroup> emailGroups;

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", role: " + role + ", birthDate: " + birthDate;
    }
}
