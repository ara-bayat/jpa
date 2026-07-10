package com.learning;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Employee employee=Employee.builder()
                .id(2)
                .name("alireza")
                .build();
        var factory= Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em=factory.createEntityManager();
        var transaction= em.getTransaction();
        transaction.begin();
        em.persist(employee);
        transaction.commit();
        em.close();
    }
}