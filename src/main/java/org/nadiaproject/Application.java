package org.nadiaproject;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class Application {
    public static void main(String[] args){ SpringApplication.run(Application.class, args);}
    @Bean
    CommandLineRunner commandLineRunner(StudentRepo studentRepo) {
        return args -> {
            Faker dummystudent = new Faker();
            for (int i = 0; i < 20; i++) {
                String firstname = dummystudent.name().firstName();
                String lastname = dummystudent.name().lastName();
                String email = String.format("%s.%s@gmail.nm", firstname, lastname);
                student student = new student(firstname, lastname, email, dummystudent.number().numberBetween(17, 55));
                studentRepo.save(student);
            }
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
////            studentRepo.findById(3L).ifPresentOrElse(System.out::println, ()-> System.out.println("student Id not found"));
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
        };
    }
}