package io.github.leofalves.clickDelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.leofalves.clickDelivery.dto.ProductDto;
import io.github.leofalves.clickDelivery.entities.Product;
import io.github.leofalves.clickDelivery.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDto> findAll() {
		//List<Product> list = repository.findAll();
		List<Product> list = repository.findAllByOrderByNameAsc();
		
		return list.stream().map(x -> new ProductDto(x))
				.collect(Collectors.toList());
	}

}
