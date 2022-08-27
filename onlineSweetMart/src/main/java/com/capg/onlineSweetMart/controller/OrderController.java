package com.capg.onlineSweetMart.controller;

import com.capg.onlineSweetMart.entity.Order;
import com.capg.onlineSweetMart.entity.OrderItem;
import com.capg.onlineSweetMart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;



@CrossOrigin("*")
@RestController
@RequestMapping
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @PostMapping("/createOrder")
    public ResponseEntity<String>createOrder (@RequestBody Order o) throws IOException {
        return new ResponseEntity<>(orderService.createOrder(o), HttpStatus.CREATED);

    }
    @GetMapping("/readAllOrder")
    public List<Order> fetchingOrder(){
        return orderService.readAllOrder();
    }
    @GetMapping("/readOrderbyid/{ordId}")
    public ResponseEntity<Order> readOrder(@PathVariable("ordId")Integer ordId)
    {
        return new ResponseEntity<>(orderService.readOrder(ordId),HttpStatus.OK);
    }
    @GetMapping("/getSweetItemListByOrderId/{ordId}")
    public List<OrderItem> getSweetItemListByOrderId(@PathVariable("ordId")Integer ordId)
    {
    	return orderService.getSweetItemListByOrderId(ordId);
    }
    @PatchMapping("/updateOrder/{ordId}")
    public ResponseEntity<String> updateorder(@PathVariable("ordId") Integer ordId, @RequestBody Order order){
        return new ResponseEntity<>(orderService.updateOrder(order, ordId), HttpStatus.OK);
    }
    @DeleteMapping("/del/{ordId}")
    private ResponseEntity<String> deleteOrder(@PathVariable("ordId") Integer ordId){
    	return new ResponseEntity<String>(orderService.deleteOrder(ordId),HttpStatus.OK);
    }
    @GetMapping("/getUserOrders/{userId}")
    public List<Order> getOrderByUserId(@PathVariable("userId")Integer userId)
    {
        return orderService.getOrderByUserId(userId);
    }

}