package org.nadiaproject;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(StudentRepo studentRepo, studentIdCardRepo studentIdCardRepo) {
        return args -> {
            Faker dummystudentcard = new Faker();

                String firstname = dummystudentcard.name().firstName();
                String lastname = dummystudentcard.name().lastName();
                String email = String.format("%s.%s@gmail.nm", firstname, lastname);
                Student student = new Student(firstname, lastname, email, dummystudentcard.number().numberBetween(17, 55));
                student.addBook( new Books(
                        "harry potter", LocalDateTime.now().minusDays(4)
                ));
            student.addBook( new Books(
                    "samir potter", LocalDateTime.now()
            ));
            student.addBook( new Books(
                    "nadia potter", LocalDateTime.now().minusYears(1)
            ));

            StudentIdCard studentIdCard = new StudentIdCard(
                       "455557899",student
               );
               student.setStudentIdCard(studentIdCard);

               student.addEnrolment(new Enrolment(new EnrolmentId(1L,1L),student, new Course("cse","IT"),LocalDateTime.now(),"rehan"));
            student.addEnrolment(new Enrolment(new EnrolmentId(1L,1L),student, new Course("cse","IT"),LocalDateTime.now().minusDays(18),"samir"));
            student.addEnrolment(new Enrolment(new EnrolmentId(1L,1L),student, new Course("cse","IT"),LocalDateTime.now().minusDays(18),"asma"));
               studentRepo.save(student);
//               studentIdCardRepo.save(studentIdCard);
               studentIdCardRepo.findById(2l).ifPresent(System.out::println);
               studentIdCardRepo.findById(1l).ifPresent(System.out::println);
//               studentRepo.deleteById(1l);
//            generateRandomStudent(studentRepo);
//            PageRequest pageRequest = PageRequest.of(0,10,
//                    Sort.by("firstname"));/// we do paging and sorting all together
//            Page<student> studentpage = studentRepo.findAll(pageRequest);
//            System.out.println(studentpage);
//            //Sorting(studentRepo);
                ;
                //JPA repository extends paging and sorting repository
                // and paging and sorting repository extends crud repository
//            student nadia = new student("nadia","malikzada","1234@gmail.com",22);
//            student hm = new student("hm2","malikzada","hm@gmail.com",32);
//            student timur = new student("timur","malikzada","timur@gmail.com",12);
//            student hm2 = new student("hm2","malikzada","hm2@gmail.com",32);
//            System.out.println("adding students");
//            studentRepo.saveAll(List.of(nadia,hm,timur,hm2));
////            System.out.println(studentRepo.count());
////            System.out.print("Number of the students");
////            studentRepo.findById(2L).ifPresentOrElse(System.out::println, ()-> System.out.println("student Id not found"));
////            studentRepo.saveAll(List.of(nadia,hm));
////            System.out.println(studentRepo.count());
            studentRepo.findById(1L).ifPresent(s -> {
                        System.out.println("Fetch books lazy");
                        List<Books> books = student.getBooks();
                        books.forEach(b ->
                        {
                            System.out.println(
                                    s.getFirstname() + " " + "borrowed " + b.getBook_name());
                        });
                    });
////            System.out.println("select students by id");
////            List<student> students = studentRepo.findAll();
////            students.forEach(System.out::println);
////            System.out.println("List of the students");
////            studentRepo.deleteById(1L);
////            System.out.println("delete student by id");
////            System.out.println(studentRepo.count());
//            studentRepo.findStudentByEmail(hm.getEmail()).ifPresentOrElse(System.out::println, () ->{
//                System.out.println("students email not found");});
//            studentRepo.findStudentsByFirstnameAndAgeGreaterThanOrEqualNative("hm2",20).forEach(System.out::println);
//            System.out.println("deleting hm2");
//            System.out.println(studentRepo.deletStudentById(2L));
//
            }
            ;
        };
    }

//    private static void Sorting(StudentRepo studentRepo) {
//        Sort sort = Sort.by("firstname").ascending().and(Sort.by("age").descending());
//        studentRepo.findAll(sort).forEach(student -> System.out.println(student.getFirstname()+ " " + student.getAge()));
//    }

//    private static void generateRandomStudent(StudentRepo studentRepo) {
//        Faker dummystudent = new Faker();
//        for (int i = 0; i < 20; i++) {
//            String firstname = dummystudent.name().firstName();
//            String lastname = dummystudent.name().lastName();
//            String email = String.format("%s.%s@gmail.nm", firstname, lastname);
//            student student = new student(firstname, lastname, email, dummystudent.number().numberBetween(17, 55));
//            studentRepo.save(student);
//        }

//}