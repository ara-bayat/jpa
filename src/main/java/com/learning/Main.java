package com.learning;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Employee employee = Employee.builder()
                .name("alireza")
                .role(Roles.employee)
                .birthDate(LocalDate.of(1988, 9, 13))
                .build();

        AccessCard accessCard = AccessCard.builder()
                .cardNumber("AC-1001")
                .issueDate(LocalDate.now())
                .active(true)
                .employee(employee)
                .build();

        employee.setAccessCard(accessCard);

        var factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        var transaction = em.getTransaction();
        transaction.begin();
        em.persist(accessCard);
        em.persist(employee);
        transaction.commit();
        em.close();
        factory.close();
    }
}