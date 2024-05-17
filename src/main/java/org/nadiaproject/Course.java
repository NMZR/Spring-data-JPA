package org.nadiaproject;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "course")
@Table(name = "course")

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "CourseName", nullable = false, columnDefinition = "VARCHAR(100)")
    private String course_name;
    @Column(name = "Department_Name", nullable = false, columnDefinition = "VARCHAR(100)")
    private String D_name;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "course")/// this course can be found in the enrolment class
    private List<Enrolment> enrolments = new ArrayList<>();

    /////////////////////////CONSTRUCTOR://////////////////////////////
    public Course() {
    }

    public Course(String course_name, String d_name) {
        this.course_name = course_name;
        D_name = d_name;
    }
////////////////////////GETTERS AND SETTERS///////////////////////////////

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getD_name() {
        return D_name;
    }

    public void setD_name(String d_name) {
        D_name = d_name;
    }

    public List<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void setEnrolments(List<Enrolment> enrolments) {
        this.enrolments = enrolments;
    }
    public void addEnrolment(Enrolment enrolment){
        if (!enrolments.contains((enrolment))) {
            enrolments.add(enrolment);

        }
    }
    public void removerenrolment(Enrolment enrolment){
        enrolments.remove(enrolment);
    }
    //    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

    //////////////////TOSTRING//////////////////////

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", course_name='" + course_name + '\'' +
                ", D_name='" + D_name + '\'' +
                '}';
    }
}
