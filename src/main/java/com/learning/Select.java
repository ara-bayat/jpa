package com.learning;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Select {

    public static void main(String[] args) {
        var factory= Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em=factory.createEntityManager();
        var employee= em.find(Employee.class,1);
        System.out.println("employee is :"+employee.toString());
        em.close();
    }
}
