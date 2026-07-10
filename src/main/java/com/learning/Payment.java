package com.learning;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAYMENT")
public class Payment {
    @Id
    @GeneratedValue
    private int id;

    private BigDecimal amount;

    private LocalDate paymentDate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Override
    public String toString() {
        return "id: " + id + ", amount: " + amount + ", paymentDate: " + paymentDate;
    }
}
