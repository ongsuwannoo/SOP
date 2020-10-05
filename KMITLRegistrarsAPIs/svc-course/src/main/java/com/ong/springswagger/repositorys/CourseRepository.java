package com.ong.springswagger.repositorys;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ong.springswagger.models.Course;



@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}