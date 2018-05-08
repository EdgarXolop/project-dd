package com.voider.project.dd.repository;

import com.voider.project.dd.model.User;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("select u from User u where u.deletedAt is null ")
    List<User> list();

	@Query("select u from User u where u.deletedAt is null and (u.name like %?1% or u.email like %?1% or u.phone like %?1%)")
    List<User> listUser(String flag);
        
    @Query("select u from User u where u.deletedAt is null and u.email = ?1 and u.password=?2")
    User login(String email, String password);

    @Query("select u from User u where u.deletedAt is null and u.email = ?1")
    User findByEmail(String email);
    
    @Modifying
    @Transactional
    @Query("update User u set u.deletedAt = now(), u.status = 2 where u.idUser = ?1")
    int deleteUser(Integer idUser);
}