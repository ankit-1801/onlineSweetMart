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
    
    @PostMapping("/ordercreate")
    public ResponseEntity<String>createOrder (@RequestBody Order o) throws IOException {
        return new ResponseEntity<>(orderService.add(o), HttpStatus.CREATED);

    }
    @GetMapping("/readOrderAll")
    public List<Order> fetchingOrder(){
        return orderService.readAll();
    }
    @GetMapping("/readorderbyid/{ordId}")
    public ResponseEntity<Order> readOrder(@PathVariable("ordId")Integer ordId)
    {
        return new ResponseEntity<>(orderService.read(ordId),HttpStatus.OK);
    }
    @GetMapping("/getSweetItemListById/{ordId}")
    public List<OrderItem> getSweetItemListById(@PathVariable("ordId")Integer ordId)
    {
    	return orderService.getSweetItemListById(ordId);
    }
    @PatchMapping("/updateorder/{ordId}")
    public ResponseEntity<String> updateorder(@PathVariable("ordId") Integer ordId, @RequestBody Order order){
        return new ResponseEntity<>(orderService.update(order, ordId), HttpStatus.OK);
    }
    @DeleteMapping("/del/{ordId}")
    private void deleteOrder(@PathVariable("ordId") Integer ordId){
    	orderService.delete(ordId);
    }
    @GetMapping("/getUserOrders/{userId}")
    public List<Order> getOrderByUserId(@PathVariable("userId")Integer userId)
    {
        return orderService.getOrderByUserId(userId);
    }

}