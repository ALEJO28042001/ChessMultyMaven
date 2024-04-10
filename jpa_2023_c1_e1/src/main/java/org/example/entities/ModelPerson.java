package org.example.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ModelPerson {
    private static ModelPerson instance = null;

    private EntityManagerFactory emf;
    private EntityManager em;

    // Private constructor to prevent instantiation from outside
    private ModelPerson() {
        // Initialize EntityManagerFactory and EntityManager
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = emf.createEntityManager();
    }

    // Method to get the singleton instance
    public static ModelPerson getInstance() {
        if (instance == null) {
            synchronized (ModelPerson.class) {
                if (instance == null) {
                    instance = new ModelPerson();
                }
            }
        }
        return instance;
    }

    // Method to save a Person entity
    public void savePerson(Person p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    // Method to search for a Person entity by id
    public Person searchPerson(int id) {
        em.getTransaction().begin();
        try {
            Person person = em.find(Person.class, id);
            return person;
        } finally {
            em.getTransaction().commit();
        }
    }

    // Method to close the EntityManager and EntityManagerFactory
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
