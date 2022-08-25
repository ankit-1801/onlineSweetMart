package com.capg.onlineSweetMart.service;

import com.capg.onlineSweetMart.entity.Order;
import com.capg.onlineSweetMart.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OrderService {
    @Autowired
    public String add(Order order);
    public String update(Order order, Integer id);
    public String delete(Integer id);
    public Order read(Integer id);
    public List<Order> getOrderByUserId(int customerId);
    public List<Order> readAll();
	public List<OrderItem> getSweetItemListById(Integer ordId);
}