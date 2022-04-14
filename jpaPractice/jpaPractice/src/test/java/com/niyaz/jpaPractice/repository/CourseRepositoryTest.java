package com.niyaz.jpaPractice.repository;

import com.niyaz.jpaPractice.entity.Course;
import com.niyaz.jpaPractice.entity.Student;
import com.niyaz.jpaPractice.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest//ithu podalana autowired nadakathu
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses=courseRepository.findAll();
        System.out.println("Courses = "+courses);
    }

    @Test//many to one
    public void saveCourseWithTeacher(){//foreign key of teacher assigned to course
        Teacher teacher= Teacher.builder()
                .firstName("prinka")
                .lastName("sing")
                .build();
        Course course=Course.builder()
                .title("python")
                .credit(7)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }
    @Test//paging and sorting
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords=
                PageRequest.of(0,3);
    Pageable secondPageWithTwoRecords=PageRequest.of(1,2);
        List<Course> courses=courseRepository.findAll(firstPageWithThreeRecords)
                .getContent();
        Long totalElements=courseRepository.findAll(firstPageWithThreeRecords)
                .getTotalElements();
        Long totalPages= Long.valueOf(courseRepository.findAll(firstPageWithThreeRecords)
                        .getTotalPages());

        System.out.println(totalElements+"variation"+totalPages);


    }
    @Test
    public void findAllSorting(){
        Pageable sortByTitle=PageRequest.of(0,2, Sort.by("title"));
        Pageable sortByCreditDesc=PageRequest.of(0,2,Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc= PageRequest.of(0,2,
                Sort.by("title")
                        .descending()
                        .and(Sort.by("credit")));
        List<Course> courses=courseRepository.findAll(sortByTitle).getContent();
        System.out.println(courses);

    }

    @Test
    public void printfindByTitleContaining(){
        Pageable firstPageTenRecords=PageRequest.of(0,10);
        List<Course> courses=courseRepository.findByTitleContaining("D",firstPageTenRecords)
                .getContent();
       // System.out.println("courses ="+courses);//mapping matthanuthnala error varuthu
    }//pagina and sorting


    //many to many third table maping ku create agum
    //one to many many to one la athae two tables la foreing key create agummmm .

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher=Teacher.builder().firstName("firs")
                .lastName("sir")
                .build();
        Student student=Student.builder()
                .firstName("abishek")
                .lastName("nityaz")
                .emailId("nia@.com")
                .build();

        Course course=Course.builder()
                .title("AI")
                .credit(3)
                .teacher(teacher)
                .build();
        course.addStudnets(student);
        courseRepository.save(course);
//entity manager vachu panlaamm neray a documentation pakanyum
    }

}