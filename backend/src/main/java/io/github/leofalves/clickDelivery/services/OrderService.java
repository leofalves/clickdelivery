package io.github.leofalves.clickDelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.leofalves.clickDelivery.dto.OrderDto;
import io.github.leofalves.clickDelivery.entities.Order;
import io.github.leofalves.clickDelivery.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderDto> findAll() {
		//List<Order> list = repository.findAll();
		List<Order> list = repository.findOrdersWithProducts();
		
		return list.stream().map(x -> new OrderDto(x))
				.collect(Collectors.toList());
	}

}
