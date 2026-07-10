package com.learning;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OneToManyExample {

    public static void main(String[] args) {
        Employee employee = Employee.builder()
                .name("alireza")
                .role(Roles.employee)
                .birthDate(LocalDate.of(1988, 9, 13))
                .build();

        Payment salary = Payment.builder()
                .amount(new BigDecimal("15000000"))
                .paymentDate(LocalDate.of(2026, 6, 1))
                .employee(employee)
                .build();

        Payment bonus = Payment.builder()
                .amount(new BigDecimal("2000000"))
                .paymentDate(LocalDate.of(2026, 6, 15))
                .employee(employee)
                .build();

        List<Payment> payments = new ArrayList<>();
        payments.add(salary);
        payments.add(bonus);
        employee.setPayments(payments);

        var factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        var transaction = em.getTransaction();
        transaction.begin();
        em.persist(employee);
        em.persist(salary);
        em.persist(bonus);
        transaction.commit();

        Employee savedEmployee = em.find(Employee.class, employee.getId());
        System.out.println("employee: " + savedEmployee);
        System.out.println("payments:");
        for (Payment payment : savedEmployee.getPayments()) {
            System.out.println("  - " + payment);
        }

        em.close();
        factory.close();
    }
}
