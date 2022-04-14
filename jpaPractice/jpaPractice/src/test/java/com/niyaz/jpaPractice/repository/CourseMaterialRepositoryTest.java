package com.niyaz.jpaPractice.repository;

import com.niyaz.jpaPractice.entity.Course;
import com.niyaz.jpaPractice.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest
{
    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial(){
//        Course course= Course.builder()
//                .title("DSA")
//                .credit(6)
//                .build();
//        CourseMaterial courseMaterial=CourseMaterial.builder()
//                .url("www.google.com")
//                .course(course)
//        .build();
//        repository.save(courseMaterial);
        //this code give error because we are saving courseMaterial without saving the course;

        Course course= Course.builder()//to make this happen cascading vera level la irukum
                //parent to child pannum we have different cascading time
                .title("DSA")
                .credit(6)//pne to one kulla () =athunen work avithu
                .build();

        CourseMaterial courseMaterial=CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();
        repository.save(courseMaterial);
        //fetch type eager nu vacha course material print panna course umm print agum
        //lazy vacha call panna print pannum
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterialList=repository.findAll();
        System.out.println("CourseMaterials = "+courseMaterialList);
    }
}