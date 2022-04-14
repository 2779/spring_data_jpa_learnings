package com.niyaz.jpaPractice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder//may be setters//builder pattern to create our object
@Table(name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name="enailid_unique",
                columnNames = "email_address"
        ))//update kuduthurukathunala thirupi create agum
public class Student
{
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName="student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )//production lala,,//based on driver mysql la matum table create panni pannum
    private Long StudentId;//sequence genrater venum increment for every inserted
    private String firstName;
    private String lastName;

    @Column(name = "email_address",
            nullable = false)
    private String emailId;
    @Embedded
    private Guardian guardian;
//repositiory la process panla,
}
