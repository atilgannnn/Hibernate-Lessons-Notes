package com.hb09.fetchtypes;

import com.hb08.manytomany.Book08;
import com.hb08.manytomany.Student08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // get methodu sonra delete methodunu kullanalım

        Student09 student = session.get(Student09.class,1002);
        //System.out.println(student);
        //session.delete(student);

        //Book09 book1 = session.get(Book09.class,101);
        for (Book09 book : student.getBookList()) {

            System.out.println(book);

        }




        tx.commit();
        session.close();

        /*
        Eager yapıda çalışırken aşağıdaki sorguda hata almıyorken FetchType_LAZY olsaydı Exception alacaktık.
        Student09'da Fetch_Type Eager ise alttaki kod eksiksiz gher şeyi getirir ama Lazy de getirmez.
        Eager'da her şeyi yukarıda önceden çektiği için yazdırırken RAM'den alır yazdırır.


         for (Book09 book : student.getBookList()) {

            System.out.println(book);

        }
        */



        sf.close();







    }



}
