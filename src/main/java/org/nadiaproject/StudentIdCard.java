package org.nadiaproject;

import jakarta.persistence.*;

@Entity(name = "studentIdCard")
@Table(name = "student_Id_Card", uniqueConstraints = {@UniqueConstraint(name = "student_card_number", columnNames = "cardNumber")})
public class StudentIdCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "cardNumber", updatable = false, length = 15)
    private String cardNumber;
    private Student student;

    public StudentIdCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    public StudentIdCard(Student student) {

        this.student = student;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    //    public void setId(Long id) {
//        this.id = id;
//    }

    public Long getId() {
        return id;
    }



//    @Override
//    public String toString() {
//        return "StudentIdCard{" +
//                "id=" + id +
//                '}';
//    }
}
