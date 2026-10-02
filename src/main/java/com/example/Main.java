package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Student student = new Student(
                "Dharshini",
                "dharshini@gmail.com",
                "AI & Data Science"
        );

        Session session = factory.openSession();

        try {
            // INSERT
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();

            System.out.println("Student inserted successfully!");
            System.out.println("Student ID: " + student.getId());

            // UPDATE
            session.beginTransaction();
            student.setCourse("Artificial Intelligence and Data Science");
            session.merge(student);
            session.getTransaction().commit();

            System.out.println("Student updated successfully!");
            System.out.println(student);

        } catch (Exception e) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
