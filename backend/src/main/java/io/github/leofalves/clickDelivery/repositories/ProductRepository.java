package io.github.leofalves.clickDelivery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.leofalves.clickDelivery.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findAllByOrderByNameAsc();

}
