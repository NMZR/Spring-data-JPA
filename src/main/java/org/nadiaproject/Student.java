package org.nadiaproject;

import jakarta.persistence.*;
import org.apache.tomcat.util.digester.ArrayStack;

import java.util.ArrayList;
import java.util.List;

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
    @OneToOne(mappedBy = "student", orphanRemoval = true,cascade = {CascadeType.PERSIST, CascadeType.REMOVE}) // mapedby forms a bidirectional relationship if you load student it will also load the student card
    private StudentIdCard studentIdCard; /// studentidcard is the owning entity.
    // orphan removal = When you have two entities with a parent-child relationship,
    // orphan removal ensures that when a child entity is no longer referenced by its parent
    @OneToMany(mappedBy = "student", orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY) /// when we delete student we delete its children
    // Always start with lazy, if the application need more data use eager or make query to get more data
    private List<Books>  books = new ArrayList<>();
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "student")/// this name comes from enrolment class
//    @JoinTable(// it will create a joinned table, which in here is enrollment.
//            name = "Enrolment",
//    joinColumns = @JoinColumn(name = "student_id",
//            foreignKey = @ForeignKey(name = "enrolment_st_fk")
//    ), inverseJoinColumns = @JoinColumn(name = "course_id",
//            foreignKey = @ForeignKey(name = "enrolment_course_fk")
//    ))

    private List<Enrolment> enrolments = new ArrayList<>();




    public Student() {
    }

    public Student(String firstname, String lastname, String email, Integer age) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }
    public void addBook(Books book){
        if (!this.books.contains(book)){
            this.books.add(book);
            book.setStudent(this); // load the book load the students
        }
    }
    public void removeBook(Books books){
        if (this.books.contains(books)){
            this.books.remove(books);
            books.setStudent(null);
        }
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
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

    public StudentIdCard getStudentIdCard() {
        return studentIdCard;
    }

    public void setStudentIdCard(StudentIdCard studentIdCard) {
        this.studentIdCard = studentIdCard;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
    //    public List<Course> getCourses() {
//        return enrolments;
//    }
//
//    public void setCourses(List<Course> courses) {
//        this.enrolments = courses;
//    }
//    public void enrolCourse(Course course){
//        enrolments.add(course);
//        course.getStudents().add(this);
//    }
//    public void unEnrollCourse(Course course){
//        enrolments.remove(course);
//        course.getStudents().remove(this);
//    }


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
