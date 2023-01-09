package com.hb10.idgeneration;

import javax.persistence.*;

@Entity
public class Student10 {


 /*
    Databaselerin GenerationType Kullanım Tercihleri

    Oracle DB - PostGreSQL ---> SEQUENCE(kontrolü developer'a bırakır, Id üretilirken başlangıç değeri veya kaç tane id cachelenecek bu gibi bilgileri developer setleyebilir)
    MySQL - Microsoft ---> IDENTITY(kontrol DB de, kendi yapısına göre id olusturur, içlerindeki en basitidir)

    GenerationType.AUTO ---> Hibernate otomatik olarak stratejiyi belirler
    GenerationType.TABLE ---> En yavaşı, o yüzen kullanılmıyor çünkü id üretmek için ekstra tablo oluşturuyor

    */

    @GeneratedValue(generator = "sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="sequence",//@GenerateValue nun generator parametresi ile aynı olması lazım
            sequenceName = "student_seq",//DB de olusacak sequence ismi
            initialValue = 1000,// id lerim 1000 ile başlasın
            allocationSize = 10)// cache leme mekanizmasında 10 adet id hazırda beklesin
    @Id
    private int id;

    @Column(name="student_name",nullable = false)
    private String name;

    private int grade;

    public int getId() {
        return id;
    }
    /*
    public void setId(int id) {
        this.id = id;
    }

    */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Book10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }


}
