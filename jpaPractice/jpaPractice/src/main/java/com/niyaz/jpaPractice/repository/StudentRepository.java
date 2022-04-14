package com.niyaz.jpaPractice.repository;

import com.niyaz.jpaPractice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>//extedns paging repo and crud repo u can press ctrl and clock the jpa
{

    List<Student> findByFirstName(String firstName);//custom method let test
    List<Student> findByFirstNameContaining(String name);//like name get where name like
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
    Student findByFirstNameAndLastName(String firstName,String lastName);
    //JPQL//based on class
    @Query("select s from Student s where s.emailId= ?1")//based on class crated not our table
    Student getStudentByEmailAddress(String emailId);//not a normal creationg completely own not following structirre

    //JPQL//based on class
    @Query("select s.firstName from Student s where s.emailId= ?1")//based on class crated not our table
    String getStudentFirstNameByEmailAddress(String emailId);//not a normal creationg completely own not following structirre

    //jpql laye panna mudila so native query la panna
    @Query(
            value = "select * from tbl_student s where s.email_address=?1",
            nativeQuery = true
    )//native
    Student getStudentByEmailAddressNative(String emailId);

    @Query(
            value = "select * from tbl_student s where s.email_address= :emailId",//emailid thaan difference
            nativeQuery = true
    )//native
    Student getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId);

    //inserting  or updating
    @Modifying// modfiying record in the table
    @Transactional//to define particular transaction
    @Query(
            value = "update tbl_student set first_name= ?1 where email_address=?2",
            nativeQuery=true
    )
    int updateStudentNameByEmailId(String firstName,String emailId);
    //relationship

}


