package com.capg.onlineSweetMart.service;

import com.capg.onlineSweetMart.entity.Order;
import com.capg.onlineSweetMart.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OrderService {
    @Autowired
    public String createOrder(Order order);
    public String updateOrder(Order order, Integer id);
    public String deleteOrder(Integer id);
    public Order readOrder(Integer id);
    public List<Order> getOrderByUserId(int customerId);
    public List<Order> readAllOrder();
	public List<OrderItem> getSweetItemListByOrderId(Integer ordId);
}