package com.hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        //!!! get methodu ile

        Student06 student = session.get(Student06.class,1001);
        System.out.println(student);

        //!!! HQL ile id si 101 olan kitabı getirin

        String hqlQuery = "FROM Book06 b WHERE b.id=101";
        Book06 book1 = session.createQuery(hqlQuery,Book06.class).uniqueResult();
        System.out.println(book1);

        //!!! Bir öğrencinin kitaplarını öğrenci id ye göre getirelim
        String hqlQuery1 = "SELECT b.id,b.name FROM Student06 s INNER JOIN s.booklist b WHERE s.id=1001";
        List<Object[]> resultList1 = session.createQuery(hqlQuery1).getResultList();
        resultList1.forEach(oa-> System.out.println(Arrays.toString(oa)));

        //!!! get() methodu ile -> Bir öğrencinin kitaplarını öğrenci id ye göre getirelim
        Student06 student1  = session.get(Student06.class,1001);
        System.out.println(student.getBooklist());





        tx.commit();
        session.close();
        sf.close();

    }


}
