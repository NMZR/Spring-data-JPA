package org.nadiaproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student,Long> {
    @Query("select s from Student s where s.email = ?1")// allow us to write custom JPAQL and SQL query
    Optional<Student> findStudentByEmail(String email);
    @Query ("select s from Student s where s.firstname = ?1 AND s.age>=?2")/// JPAQL query
    List<Student> findStudentsByFirstnameAndAgeGreaterThan(String firstname,
                                                           Integer age);

    @Query (value = "select * from student  where first_name = ?1 AND age >= ?2", nativeQuery = true) /// using the native Query
    List<Student> findStudentsByFirstnameAndAgeGreaterThanOrEqualNative(String firstname,
                                                                        Integer age);
    /// instead of ussing ?1 or ?2 we can use :firstname or : age, but we have to specify the firstname and age inside the
    // method by using the @param annotation in the method
    // it will look like this @param("firstname") String firstname.
    //

    /// why native query?
    //if you use the nativequery, and you are willing to change the database, then the native query will not work.
    // with jpaql we can use the query after changing the database, the JPAQL will still work , if we transition from postgress to Mysql.
    // use the JPQL everytime.
    /// if we want to delete the students the query wont work. we have to create a new query for that
    @Transactional
    // we use it to insure the data intigrity and data consistency inside the database. it will do the transaction managment, it comes from hibernate.
    @Modifying
    // tells the spring data that the query does not need to map anything in the database, it will modify data our table.
    @Query("delete from Student x where x.id = ?1")
    int deletStudentById(Long id);
    ///

}

