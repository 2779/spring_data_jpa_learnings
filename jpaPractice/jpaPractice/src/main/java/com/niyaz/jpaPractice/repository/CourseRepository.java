package com.niyaz.jpaPractice.repository;


import com.niyaz.jpaPractice.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long>//extends paging and sorting repository
{//yu cna crate and it will retun page and sorting default mwthod and custom method//test la irukut pathuko

    Page<Course> findByTitleContaining(
            String title,
            Pageable pageable);

}
