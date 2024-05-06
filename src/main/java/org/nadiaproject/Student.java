package org.nadiaproject;

import jakarta.persistence.*;
@Entity(name = "Student")
@Table(name = "student", uniqueConstraints = {@UniqueConstraint(name = "student_email", columnNames = "Email")})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", updatable = false)
    private Long id;
    @Column(name = "FirstName", nullable = false, columnDefinition = "VARCHAR(50)")
    private String firstname;
    @Column(name = "LastName", nullable = false, columnDefinition = "VARCHAR(50)")
    private String lastname;
    @Column(name = "Email", nullable = false,unique = true,columnDefinition = "VARCHAR(50)")
    private String email;
    @Column(name = "Age", nullable = false)
    private Integer age;

    public Student() {
    }

    public Student(String firstname, String lastname, String email, Integer age) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
