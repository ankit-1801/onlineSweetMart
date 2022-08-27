package com.capg.onlineSweetMart.serviceImpl;

import com.capg.onlineSweetMart.entity.SweetItem;
import com.capg.onlineSweetMart.entity.Order;
import com.capg.onlineSweetMart.entity.OrderItem;
import com.capg.onlineSweetMart.exception.OrderNotFoundException;
import com.capg.onlineSweetMart.repository.OrderRepository;
import com.capg.onlineSweetMart.repository.SweetItemRepository;
import com.capg.onlineSweetMart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private SweetItemRepository sweetItemRepository;

    @Override
    public String createOrder(Order order) {
    	
        order.setOrderDate(LocalDate.now());
        order.setDispatchDate(LocalDate.now());
        float cost = 0;
        //importanttt
//        for(OrderItem item : order.getSweetItemList()) {
//        	SweetItem med = sweetItemRepository.findById(item.getSweetItemId()).orElseThrow(()->new OrderNotFoundException("Medcine not found"));;
//            cost+=med.getMedicineCost();
//        }
        
        order.setTotalCost(cost);
        orderRepository.save(order);
        return "Order created!!";
    }

    @Override
    public String updateOrder(Order order, Integer id) {
        Order o=orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("Order with id "+id+" is not found"));

        boolean needUpdate = false;
        if (order.getTotalCost() !=0.0)
        {
            o.setOrderId(order.getOrderId());
            needUpdate = true;
        }
        if(needUpdate) {
        	orderRepository.save(o);
            return "order updated successfully";
        }
        return "Nothing to update";
    }

    @Override
    public String deleteOrder(Integer id) {
    	orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("Order with id "+id+" is not found"));
    	orderRepository.deleteById(id);
        return " Order deleteed ";
    }

    @Override
    public Order readOrder(Integer id) {
        Order order=orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("order with id "+id+" is not found"));
        return order;
    }

    @Override
    public List<Order> readAllOrder() {
        List<Order> orderList=new ArrayList<Order>();
        orderRepository.findAll().forEach(order -> orderList.add(order));
        return orderList;
    }

	@Override
	public List<Order> getOrderByUserId(int customerId) {
		List <Order> orderList=orderRepository.findByUserId(customerId);
        return orderList;
	}

	@Override
	public List<OrderItem> getSweetItemListByOrderId(Integer ordId) {
		Order order=orderRepository.findById(ordId).orElseThrow(()->new OrderNotFoundException("order with id "+ordId+" is not found"));
		return order.getSweetItemList();
	}

}