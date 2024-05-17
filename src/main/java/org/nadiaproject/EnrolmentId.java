package org.nadiaproject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
//// THIS CLASS WORKS AS COMPOSITE KEY IN THE DATABASE.
@Embeddable //////Implementing Serializable allows instances of EnrolmentId to be easily serialized and deserialized, which is crucial in distributed systems where objects
// may need to be transmitted over a network,
// or stored and retrieved from disk
public class EnrolmentId implements Serializable {
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "course_id")
    private Long courseId;
    ///////////////////////CONSTRUCTOR/////////////////////////
    public EnrolmentId() {
    }

    public EnrolmentId(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
    /////////////////////GETTERS AND SETTERS//////////////////////

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
    /////////////////////TOSTRING//////////////////////////

    @Override
    public String toString() {
        return "EnrolmentId{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }
////// IN ORDER TO HAVE THESE FIEDS AS COMPOSITE KEY(PK,FK) WE NEED TO IMPLEMENT THE EQUALS AND HASHCODE.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrolmentId that = (EnrolmentId) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}
