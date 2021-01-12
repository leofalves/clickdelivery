package io.github.leofalves.clickDelivery.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.github.leofalves.clickDelivery.entities.Order;
import io.github.leofalves.clickDelivery.entities.OrderStatus;

public class OrderDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String address;
	private Long latitude;
	private Long longitude;
	private Instant moment;
	private OrderStatus status;
	private Double total;
	
	private List<ProductDto> products = new ArrayList<>();
	
	
	public OrderDto() {
		
	}

	public OrderDto(Long id, String address, Long latitude, Long longitude, Instant moment, 
				OrderStatus status, Double total) {
		this.id = id;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
		this.total = total;
	}
	
	public OrderDto(Order entity) {
		id = entity.getId();
		address = entity.getAddress();
		latitude = entity.getLatitude();
		longitude = entity.getLongitude();
		moment = entity.getMoment();
		status = entity.getStatus();
		total = entity.getTotal();
		products = entity.getProducts().stream()
							.map(x -> new ProductDto(x))
							.collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<ProductDto> getProducts() {
		return products;
	}
}
