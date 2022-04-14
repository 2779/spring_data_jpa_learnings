package com.niyaz.jpaPractice.repository;

import com.niyaz.jpaPractice.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long>
{
}
