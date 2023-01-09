package com.hb01.annotation;

import javax.persistence.*;


//Bu Hibernate için gerekli olan Entity Class'dır.  --> Entity Class = POJO Class <--

//@Entity annotation'i koyduğumuz sınıfı DB(database) de bir tabloya karşılık getirir.
@Entity
@Table(name="t_student01")//DB de tablo ismim "t_student01" olarak değişti.
public class Student01 {//DB'de "student01" isminde tablo oluşturur.(Küçük harfle başlar)

    @Id//primary-key olusmasini sagliyor
    //@Column(name="std_id")(tablo field ismi degistirmek icin)
    private int id;

    //@Column zorunlu değil ancak customize edebilmek için gerekli
    @Column(name="student_name",length = 100,nullable = false,unique = false)
    private String name;

    //@Transient//DB deki tabloda "grade" adında bir kolon oluşmasını engeller
    private int grade;

//    @Lob// --> Large Object ile büyük boyutlu datalar tutulabilir
//    private byte[] image;  --> (BLOB -- CLOB)

    //Getter - Setter *********************************************************


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    //toString() *********************************************************


    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }






}
