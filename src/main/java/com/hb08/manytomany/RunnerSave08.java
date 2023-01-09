package com.hb08.manytomany;
import com.h07.bi_onetomany.Book07;
import com.h07.bi_onetomany.Student07;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave08 {

    public static void main(String[] args) {

        Student08 student1 = new Student08();
        student1.setId(1001);
        student1.setName("Şeyma Özçam");
        student1.setGrade(95);

        Student08 student2 = new Student08();
        student2.setId(1002);
        student2.setName("Recep Bey");
        student2.setGrade(95);

        Student08 student3 = new Student08();
        student3.setId(1003);
        student3.setName("Emir Bey");
        student3.setGrade(95);

        Book08 book1 = new Book08();
        book1.setId(101);
        book1.setName("Art Book");

        Book08 book2 = new Book08();
        book2.setId(102);
        book2.setName("Math Book");

        List<Book08> bookist1 = new ArrayList<>();
        bookist1.add(book1);
        bookist1.add(book2);
        student1.setBookList(bookist1);

        List<Book08> bookist2 = new ArrayList<>();
        bookist2.add(book1);
        bookist2.add(book2);
        student2.setBookList(bookist2);

        List<Book08> bookist3 = new ArrayList<>();
        bookist3.add(book1);
        student3.setBookList(bookist3);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).addAnnotatedClass(Book08.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(book1);
        session.save(book2);


        tx.commit();
        session.close();
        sf.close();

    }







}
