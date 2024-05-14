package org.nadiaproject;

import jakarta.persistence.*;

@Entity(name = "studentIdCard")
@Table(name = "student_Id_Card", uniqueConstraints = {
        @UniqueConstraint(
                name = "student_card_number", columnNames = "cardNumber")})
public class StudentIdCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "cardNumber", updatable = false, length = 15)
    private String cardNumber;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //  cascade propagate all the operation,
    /// default fetch type is eager for one to one relationship: for one to one eager is best option.
    // Lazy type: when you load you load one entity data not both of them,
    // but with eager the data will be load from both entity.
    // unidirectional relation which is only one way, like one to one.
    //
    @JoinColumn(name = "student_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "student_idfk "))
    private Student student;

    public StudentIdCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    public StudentIdCard() {

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

    @Override
    public String toString() {
        return "StudentIdCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", student=" + student +
                '}';
    }
}
