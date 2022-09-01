package com.capg.onlineSweetMart.service;

import com.capg.onlineSweetMart.dto.OrderDto;
import com.capg.onlineSweetMart.dto.OrderItemDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OrderService {
    @Autowired
    public String createOrder(OrderDto orderDto);
    public String updateOrder(OrderDto orderDto, Integer id);
    public String deleteOrder(Integer id);
    public OrderDto readOrder(Integer id);
    public List<OrderDto> getOrderByUserId(int customerId);
    public List<OrderDto> readAllOrder();
	public List<OrderItemDto> getSweetItemListByOrderId(Integer ordId);
}