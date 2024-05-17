package org.nadiaproject;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity(name = "Enrolment")
@Table(name = "enrolment")
public class Enrolment {
    @EmbeddedId //  we got this from our composite class
    private EnrolmentId id;
    @ManyToOne
    @MapsId("studentId") // this student is part of the id
    @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "student_fk"))
    private Student student;
    @ManyToOne
    @MapsId("courseId") // this student is part of the id
    @JoinColumn(name = "course_id",foreignKey = @ForeignKey(name = "course_fk"))
    private Course course;
    @Column(name = "created_at",nullable = false,columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAT;
    @Column(name = "teacher",nullable = false,columnDefinition = "VARCHAR(50)")
    private String Teacher;

    /////////////CONSTRACTOR////////////////////

    public Enrolment(EnrolmentId id, Student student, Course course, LocalDateTime createdAT, String teacher) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.createdAT = createdAT;
        this.Teacher = teacher;
    }

    public Enrolment() {
    }

    public Enrolment( Student student, Course course,LocalDateTime createdAT) {
        this.student = student;
        this.course = course;
        this.createdAT = createdAT;
    }
    /////////GETTERS&SETTERS//////////////

    public EnrolmentId getId() {
        return id;
    }

    public void setId(EnrolmentId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(LocalDateTime createdAT) {
        this.createdAT = createdAT;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }
}
