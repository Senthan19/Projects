package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Tasks;

@Repository
public interface TaskRepository extends JpaRepository<Tasks,Integer>{
	List<Tasks> findByUser_Id(Integer userId);

}
