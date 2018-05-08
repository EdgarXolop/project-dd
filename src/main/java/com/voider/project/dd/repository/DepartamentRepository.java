package com.voider.project.dd.repository;

import java.util.List;

import com.voider.project.dd.model.Role;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DepartamentRepository extends CrudRepository<Role,Long>{
    
	@Query("SELECT d FROM Role d WHERE d.deletedAt is null")
	List<Role> list();
}