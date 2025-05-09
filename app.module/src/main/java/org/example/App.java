package org.example;

import java.time.Instant;
import java.util.Date;

import entities.Cat;
import entities.Owner;
import entities.Breed;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

    SessionFactory sessionFactory;

    protected void setUp() {

        sessionFactory = new Configuration()
                .addAnnotatedClass(Cat.class)
                .addAnnotatedClass(Owner.class)
                .addAnnotatedClass(Breed.class)
                .buildSessionFactory();

    }

    public static void main(String[] args) {

        var app = new App();

        app.setUp();

        app.sessionFactory.inTransaction(session -> {
            session.persist(new Owner("owner", Date.from(Instant.now())));
        });

        System.out.println("Configuration DONE");

    }

}
