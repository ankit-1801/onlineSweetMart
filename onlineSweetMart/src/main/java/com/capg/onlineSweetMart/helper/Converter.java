package com.capg.onlineSweetMart.helper;

import org.springframework.stereotype.Component;
import com.capg.onlineSweetMart.entity.*;

import com.capg.onlineSweetMart.dto.*;

import java.util.*;

import org.springframework.beans.BeanUtils;

@Component
public class Converter {
	
     public User convertUserDtoToUser(UserDto userDto) {
    	 User user = new User();
    	 if(userDto!=null) {
    		 BeanUtils.copyProperties(userDto, user);
    	 }
    	 return user;
     }
     
     
     public UserDto convertUserToUserDto(User user) {
    	 UserDto userDto = new UserDto();
    	 if(user!=null) {
    		 BeanUtils.copyProperties(user, userDto);
    	 }
    	 return userDto;
     }
     
     
     public Order convertOrderDtoToOrder(OrderDto orderDto) {
    	 Order order = new Order();
    	 if(orderDto!=null) {
    		 BeanUtils.copyProperties(orderDto, order);
    		 List<OrderItem> li = new ArrayList<OrderItem>();
    		 if(orderDto.getSweetItemList()!=null) {
    		 for(OrderItemDto orderItemDto: orderDto.getSweetItemList()) {
    			  li.add(convertOrderItemDtoToOrderItem(orderItemDto));
    		 }
    		 order.setSweetItemList(li);
    		 }
         }
    	 return order;
     }
     
     
     public OrderDto convertOrderToOrderDto(Order order) {
    	 OrderDto orderDto = new OrderDto();
    	 if(order!=null) {
    		 BeanUtils.copyProperties(order, orderDto);
    		 List<OrderItemDto> li = new ArrayList<OrderItemDto>();
    		 if(order.getSweetItemList()!=null) {
    		 for(OrderItem orderItem: order.getSweetItemList()) {
   			  li.add(convertOrderItemToOrderItemDto(orderItem));
    		 }
    		 orderDto.setSweetItemList(li);
    		 }
    	 }
    	 return orderDto;
     }
     
     
     public OrderItem convertOrderItemDtoToOrderItem(OrderItemDto orderItemDto) {
    	 OrderItem orderItem = new OrderItem();
    	 if(orderItemDto!=null) {
    		 BeanUtils.copyProperties(orderItemDto, orderItem);
    	 }
    	 return orderItem;
     }
     
     
     public OrderItemDto convertOrderItemToOrderItemDto(OrderItem orderItem) {
    	 OrderItemDto orderItemDto = new OrderItemDto();
    	 if(orderItem!=null) {
    		 BeanUtils.copyProperties(orderItem, orderItemDto);
    	 }
    	 return orderItemDto;
     }
     
     public SweetItems convertSweetItemsDtoToSweetItems(SweetItemsDto sweetItemsDto) {
    	 SweetItems sweetItems = new SweetItems();
    	 if(sweetItemsDto!=null) {
    		 BeanUtils.copyProperties(sweetItemsDto, sweetItems);
    	 }
    	 return sweetItems;
     }
     
     
     public SweetItemsDto convertSweetItemsToSweetItemsDto(SweetItems user) {
    	 SweetItemsDto sweetItemsDto = new SweetItemsDto();
    	 if(user!=null) {
    		 BeanUtils.copyProperties(user, sweetItemsDto);
    	 }
    	 return sweetItemsDto;
     }
     
     
}
