package io.github.leofalves.clickDelivery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.github.leofalves.clickDelivery.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	// JPQL
	@Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products "
			+ " WHERE obj.status = 0 ORDER BY obj.moment ASC")
	List<Order> findOrdersWithProducts();

}
