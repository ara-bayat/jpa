package com.learning;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMAIL_GROUP")
public class EmailGroup {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "EMPLOYEE_EMAIL_GROUP",
            joinColumns = @JoinColumn(name = "email_group_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    @Builder.Default
    private List<Employee> employees = new ArrayList<>();

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name;
    }
}
