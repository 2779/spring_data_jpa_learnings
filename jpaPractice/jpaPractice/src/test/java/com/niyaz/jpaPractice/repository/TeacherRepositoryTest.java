package com.niyaz.jpaPractice.repository;

import com.niyaz.jpaPractice.entity.Course;
import com.niyaz.jpaPractice.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDBA= Course.builder()
                .title("DBA")
                .credit(5)
                .build();
        Course courseMBA= Course.builder()
                .title("mba")
                .credit(3)
                .build();
        Teacher teacher= Teacher.builder()
                .firstName("out")
                .lastName("khan")
              //  .courses(List.of(courseDBA,courseMBA))//list nala
                .build();
        teacherRepository.save(teacher);
        //by default everything is optional relationship
    }

}