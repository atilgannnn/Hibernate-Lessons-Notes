package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

    public static void main(String[] args) {

        //Burada tabloya atayacağım değerleri Java'ca girdim.
        Student01 student1 = new Student01();
        student1.setId(1001);
        student1.setName("Samet Güler");
        student1.setGrade(90);

        Student01 student2 = new Student01();
        student2.setId(1002);
        student2.setName("Tarık");
        student2.setGrade(90);

        Student01 student3 = new Student01();
        student3.setId(1003);
        student3.setName("Miraç");
        student3.setGrade(70);

        //Configuration oluşturmam lazım.JDBC'de girdiğim her şeyi "hibernate.cfg.xml" dosyasına koymuştum. Aşağıdaki kodda o dosyanın adresini verdim.
        //Ayrıca değerleri döndüreceğim Class'ı da işaret ettim.
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

        //Hibernate'e Configuration Dosyamı ve Entity Class'ımı bildirdim.
        //Hibernate'den database e data göndermeden önce Session açıyorum. Ardından da Transaction'ı başlatıyorum.
        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();


        //session.save(student1);
        //session.save(student2);
        //session.save(student3);
        //tx.commit() ile Session arasına ne yazarsam DB'ye gidecek.tx.commit() yazmazsam DB ye bilgiler GİTMEZ!!!
        tx.commit();

        //RAM'den yememek için bu ikisini kapatmayı unutmuyoruz...
        session.close();
        sf.close();



        }


    }




