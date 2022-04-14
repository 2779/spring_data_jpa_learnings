package com.niyaz.jpaPractice.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @SequenceGenerator(
            name="course_sequence",
            sequenceName="course_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;
    @OneToOne(
            mappedBy = "course"//bydirectional//ithu podama athu matum potaa unidirectioanl
    )


    private CourseMaterial courseMaterial;
    //many to one

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="teacher_id",
            referencedColumnName = "teacherId"


    )

    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),//invertion column um mention panrom
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )

    )

    private List<Student> students;
    public void addStudnets(Student student){
        if(students==null) students=new ArrayList<>();
        students.add(student);//tabel create pantapa whole application thaan run pannanuma nu therilaa
    }
}
