package org.example;

import org.example.entities.*;

public class Main {
    public static void main(String[] args) {
    	
    	Person p = new Person();
    	ModelPerson mp= ModelPerson.getInstance();
		
		mp.savePerson(p);
    	/*
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), new HashMap<>());

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");


        EntityManager em = emf.createEntityManager();  // represents the context

        try {

            em.getTransaction().begin();
            
            Person p = new Person();
            p.setId(8L);
            p.setName("Alejo");
            p.setEdad(30);
            em.persist(p);
            
            em.getTransaction().commit();

            // After persisting the user, you can execute a SQL query to retrieve data
            //String sql = "SELECT p FROM user p"; // JPQL query to select all users
            //var resultList = em.createQuery(sql, user.class).getResultList();

            // Clean the table
            em.getTransaction().begin();
            //em.createQuery("DELETE FROM user").executeUpdate();
            em.getTransaction().commit();
            
            // Print the result
            /*
            System.out.println("users in the database:");
            for (user user : resultList) {
                System.out.println(user.getId() + " - " + user.getName());
            
        }
        catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        } 
        finally {
            em.close();
        }*/
    }
}