package com.ong.springswagger.repositorys;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ong.springswagger.models.Lecturer;



@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long>{

}