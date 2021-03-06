package com.ong.springswagger.repositorys;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ong.springswagger.models.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	@Query("SELECT t FROM Student t WHERE t.username = ?1")
	Optional<Student> findByUsername(String username);
}