package com.hb03.uni_onetoone;

import com.hb02.embeddable.Student02;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {

    public static void main(String[] args) {

        Student03 student1 = new Student03();
        student1.setId(1001);
        student1.setName("Atılgan Ulaşan");
        student1.setGrade(90);

        Student03 student2 = new Student03();
        student2.setId(1002);
        student2.setName("Rıdvan A");
        student2.setGrade(90);

        Student03 student3 = new Student03();
        student3.setId(1003);
        student3.setName("Errayn");
        student3.setGrade(90);

        Diary diary1 = new Diary();
        diary1.setId(101);
        diary1.setName("Atılgan Beyin Günlüğü");
        diary1.setStudent(student1);

        Diary diary2 = new Diary();
        diary2.setId(102);
        diary2.setName("Rıdvan Beyin Günlüğü");
        diary2.setStudent(student2);



        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);


        tx.commit();
        session.close();
        sf.close();



    }


}
