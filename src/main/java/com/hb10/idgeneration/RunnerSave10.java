package com.hb10.idgeneration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {

    public static void main(String[] args) {


        com.hb10.idgeneration.Student10 student1 = new com.hb10.idgeneration.Student10();
        student1.setName("Alper K");
        student1.setGrade(85);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student10.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);



        tx.commit();
        session.close();
        sf.close();



    }


}
