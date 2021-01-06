package io.github.leofalves.clickDelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.leofalves.clickDelivery.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
