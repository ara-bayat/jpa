package com.learning;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Update {

    public static void main(String[] args) {
        var factory= Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager=factory.createEntityManager();
        var employee= entityManager.find(Employee.class,1);
        System.out.println("employee is :"+employee.toString());
        employee.setName("mohammad");
        var transaction= entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        transaction.commit();
        entityManager.close();
    }
}
