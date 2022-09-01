package com.capg.onlineSweetMart.serviceImpl;

import com.capg.onlineSweetMart.entity.SweetItems;
import com.capg.onlineSweetMart.dto.OrderDto;
import com.capg.onlineSweetMart.dto.OrderItemDto;
import com.capg.onlineSweetMart.entity.Order;
import com.capg.onlineSweetMart.entity.OrderItem;
import com.capg.onlineSweetMart.exception.OrderNotFoundException;
import com.capg.onlineSweetMart.helper.Converter;
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
    
    @Autowired
    public Converter converter;

    @Override
    public String createOrder(OrderDto orderDto) {
    	Order order = converter.convertOrderDtoToOrder(orderDto);
        order.setOrderDate(LocalDate.now());
        order.setDispatchDate(LocalDate.now());
        float cost = 0;
        for(OrderItem item : order.getSweetItemList()) {
        	SweetItems med = sweetItemRepository.findById(item.getSweetItemId()).orElseThrow(()->new OrderNotFoundException("Order not found"));;
            cost+=med.getPrice();
        }
        
        order.setTotalCost(cost);
        orderRepository.save(order);
        return "Order created!!";
    }

    @Override
    public String updateOrder(OrderDto orderDto, Integer id) {
        Order o=orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("Order with id "+id+" is not found"));
        Order order = converter.convertOrderDtoToOrder(orderDto);
        if (order.getTotalCost() !=0.0)
        {
            o.setOrderId(order.getOrderId());
        }
        if(order.getStatus()!= null) {
        	o.setStatus(order.getStatus());
        }	
        orderRepository.save(o);
        return "Order updated!";
    }

    @Override
    public String deleteOrder(Integer id) {
    	orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("Order with id "+id+" is not found"));
    	orderRepository.deleteById(id);
        return " Order deleteed ";
    }

    @Override
    public OrderDto readOrder(Integer id) {
        Order order=orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("Order with id "+id+" is not found"));
        OrderDto orderDto = converter.convertOrderToOrderDto(order); 
        return orderDto;
    }

    @Override
    public List<OrderDto> readAllOrder() {
        List<OrderDto> orderList=new ArrayList<OrderDto>();
        orderRepository.findAll().forEach(order -> orderList.add(converter.convertOrderToOrderDto(order)));
        return orderList;
    }

	@Override
	public List<OrderDto> getOrderByUserId(int customerId) {
		List <Order> orderList=orderRepository.findByUserId(customerId);
		List<OrderDto> li = new ArrayList<>();
		for(Order order: orderList) {
			li.add(converter.convertOrderToOrderDto(order));
		}
        return li;
	}

	@Override
	public List<OrderItemDto> getSweetItemListByOrderId(Integer ordId) {
		Order order=orderRepository.findById(ordId).orElseThrow(()->new OrderNotFoundException("Order with id "+ordId+" is not found"));
		OrderDto orderDto = converter.convertOrderToOrderDto(order);
		return orderDto.getSweetItemList();
	}

}