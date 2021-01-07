package io.github.leofalves.clickDelivery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.leofalves.clickDelivery.dto.OrderDto;
import io.github.leofalves.clickDelivery.dto.ProductDto;
import io.github.leofalves.clickDelivery.entities.Order;
import io.github.leofalves.clickDelivery.entities.OrderStatus;
import io.github.leofalves.clickDelivery.entities.Product;
import io.github.leofalves.clickDelivery.repositories.OrderRepository;
import io.github.leofalves.clickDelivery.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDto> findAll() {
		//List<Order> list = repository.findAll();
		List<Order> list = repository.findOrdersWithProducts();
		
		return list.stream().map(x -> new OrderDto(x))
				.collect(Collectors.toList());
	}
	
	
	@Transactional
	public OrderDto insert(OrderDto dto) {
		Order order = new Order(null, 
								dto.getAddress(), 
								dto.getLatitude(), 
								dto.getLongitude(), 
								Instant.now(), 
								OrderStatus.PENDING);
		
		/*
		 * Varre os produtos do Order
		 */
		for (ProductDto p : dto.getProducts()) {
			
			/*Instancia um produto sem ir ao banco para salvar juntamente com o Order*/
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		
		order = repository.save(order);
		return new OrderDto(order);
	}
	
	@Transactional
	public OrderDto setDelivered(Long id) {
		Order order = repository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = repository.save(order);
		return new OrderDto(order);
	}

}
