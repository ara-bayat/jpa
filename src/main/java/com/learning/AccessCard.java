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
@Table(name = "ACCESS_CARD")
public class AccessCard {
    @Id
    @GeneratedValue
    private int id;

    private String cardNumber;

    private LocalDate issueDate;

    private boolean active;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Override
    public String toString() {
        return "id: " + id + ", cardNumber: " + cardNumber + ", issueDate: " + issueDate + ", active: " + active;
    }
}
