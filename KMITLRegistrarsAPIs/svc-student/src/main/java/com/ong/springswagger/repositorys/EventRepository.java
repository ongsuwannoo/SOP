package com.ong.springswagger.repositorys;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ong.springswagger.models.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
	
}