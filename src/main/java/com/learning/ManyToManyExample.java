package com.learning;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManyToManyExample {

    public static void main(String[] args) {
        Employee alireza = Employee.builder()
                .name("alireza")
                .role(Roles.employee)
                .birthDate(LocalDate.of(1988, 9, 13))
                .build();

        Employee sara = Employee.builder()
                .name("sara")
                .role(Roles.teacher)
                .birthDate(LocalDate.of(1992, 3, 21))
                .build();

        EmailGroup developers = EmailGroup.builder()
                .name("developers")
                .build();

        EmailGroup managers = EmailGroup.builder()
                .name("managers")
                .build();

        List<Employee> developerMembers = new ArrayList<>();
        developerMembers.add(alireza);
        developerMembers.add(sara);
        developers.setEmployees(developerMembers);

        List<Employee> managerMembers = new ArrayList<>();
        managerMembers.add(alireza);
        managers.setEmployees(managerMembers);

        var factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        var transaction = em.getTransaction();
        transaction.begin();
        em.persist(alireza);
        em.persist(sara);
        em.persist(developers);
        em.persist(managers);
        transaction.commit();

        EmailGroup savedDevelopers = em.find(EmailGroup.class, developers.getId());
        System.out.println("email group: " + savedDevelopers);
        System.out.println("members:");
        for (Employee employee : savedDevelopers.getEmployees()) {
            System.out.println("  - " + employee);
        }

        em.close();
        factory.close();
    }
}
