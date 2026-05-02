package com.klef.fsad.exam;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;


public class ClientDemo implements CommandLineRunner {

   
    private EntityManager em;

    
    public void run(String... args) throws Exception {

     
        Delivery d1 = new Delivery();
        d1.setName("Order1");
        d1.setStatus("Delivered");
        d1.setDate(new Date());

        em.persist(d1);
 
        
        
        
        Delivery d2 = new Delivery();
        d2.setName("Order2");
        d2.setStatus("Pending");
        d2.setDate(new Date());

        em.persist(d2);

        System.out.println("Records inserted...");

       
        Query q = em.createQuery("delete from Delivery where id = ?1");
        q.setParameter(1, 1);

        int rows = q.executeUpdate();
        System.out.println("Deleted rows: " + rows);
    }
}