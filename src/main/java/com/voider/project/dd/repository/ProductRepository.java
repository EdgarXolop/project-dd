package com.voider.project.dd.repository;

import java.util.List;

import com.voider.project.dd.model.Product;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends CrudRepository<Product, Long>{
	@Query("select p from Product p where p.deletedAt is null")
	List<Product> listProduct();
	
	@Modifying
    @Transactional
    @Query("update Product p set p.deletedAt = now(), p.idUser = ?2 where p.idProduct = ?1")
    Integer deleteProduct(Integer idProduct, Integer idUser);

}
