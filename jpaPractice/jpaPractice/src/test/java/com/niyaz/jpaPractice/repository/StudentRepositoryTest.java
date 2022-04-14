package com.niyaz.jpaPractice.repository;

import com.niyaz.jpaPractice.entity.Guardian;
import com.niyaz.jpaPractice.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
//normally ---->  @DataJpaTest it will help you to test repository layer database impact agathu flush pannidum mudinchonae
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent()
    {
        //builder pattern to create our object
        Student student= Student.builder().emailId("niyaz@gmail.com").firstName("niyaz")
                .lastName("mohamed")
//                .guardianName("nazar")
//                .guardianEmail("nazat@gmail.com")
//                .guardianMobile("123434342334")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian=Guardian.builder()
                .email("niyaz@@gmail.com")
                .mobile("4242344543534")
                .name("guard").build();
        Student student=Student.builder().firstName("niyaz")
                .emailId("niyaz@gmail.comm")
                .lastName("mohamed")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList=studentRepository.findAll();
        System.out.println("Student List"+ studentList);

    }
    @Test
    public void printStudentByFirstName(){
        List<Student> students=studentRepository.findByFirstName("niyaz");//custom method
        System.out.println("stuednt"+ students);
    }
    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students=studentRepository.findByFirstNameContaining("n");//custom method
        System.out.println("stuednt"+ students);
    }
    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students=studentRepository.findByGuardianName("nazar");
        System.out.println("students "+ students);
        //https://docs.spring.io/spring-data/data-jpa/docs/1.1.x/reference/html/
       // youtube la refernce documentation link   jpql
    }
    @Test
    public void printgetStudentByEmailAddress(){
        Student student=studentRepository.getStudentByEmailAddress("niyaz@gmail.com");
        System.out.println("students"+student);
    }
    @Test
    public void printgetStudentFirstNameByEmailAddress(){
       String firstName=studentRepository.getStudentFirstNameByEmailAddress("niyaz@gmail.com");
        System.out.println("firstName "+firstName);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student student=studentRepository.getStudentByEmailAddressNative(
                "niyaz@gmail.com"
        );
        System.out.println("students"+student);
    }
    @Test
    public void getStudentByEmailAddressNativeNamedParam(){
        Student student=studentRepository.getStudentByEmailAddressNativeNamedParam(
                "niyaz@gmail.com"
        );
        System.out.println("students "+student);
    }
   //everything is fetching the dataaaaaa;
    //nowww
    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId("" +
                "ni","niyaz@gmail.com");
    }



}