package com.hb12.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student12.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
/*
        System.out.println("İlk get işlemi 1 id li öğrenci için");
        Student12 student1 = session.get(Student12.class,1L);

        session.clear();

        System.out.println("İkinci get işlemi 1 id li öğrenci için");
        Student12 student2 = session.get(Student12.class,1L);

 */








        tx.commit();
        session.close();

        //first level cache mekanizmasında alt satırdaki kodlar için yeni bir query oluşturulur.
        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();
        System.out.println("Session close sonrası  get işlemi 1 id li öğrenci için");
        Student12 student3 = session2.get(Student12.class,1L);



        tx2.commit();
        session2.close();
        sf.close();







    }



}
