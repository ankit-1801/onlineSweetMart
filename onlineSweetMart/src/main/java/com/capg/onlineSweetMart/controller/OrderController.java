package com.capg.onlineSweetMart.controller;

import com.capg.onlineSweetMart.dto.OrderDto;
import com.capg.onlineSweetMart.dto.OrderItemDto;
import com.capg.onlineSweetMart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import com.capg.onlineSweetMart.helper.Converter;

@CrossOrigin("*")
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @Autowired
    Converter converter;
    
    @PostMapping("/createOrder")
    public ResponseEntity<String>createOrder (@RequestBody OrderDto o) throws IOException {
        return new ResponseEntity<>(orderService.createOrder(o), HttpStatus.CREATED);

    }
    @GetMapping("/readAllOrder")
    public List<OrderDto> fetchingOrder(){
        return orderService.readAllOrder();
    }
    @GetMapping("/readOrderbyid/{ordId}")
    public ResponseEntity<OrderDto> readOrder(@PathVariable("ordId")Integer ordId)
    {
        return new ResponseEntity<>(orderService.readOrder(ordId),HttpStatus.OK);
    }
    @GetMapping("/getSweetItemListByOrderId/{ordId}")
    public List<OrderItemDto> getSweetItemListByOrderId(@PathVariable("ordId")Integer ordId)
    {
    	return orderService.getSweetItemListByOrderId(ordId);
    }
    @PatchMapping("/updateOrder/{ordId}")
    public ResponseEntity<String> updateorder(@PathVariable("ordId") Integer ordId, @RequestBody OrderDto orderDto){
        return new ResponseEntity<>(orderService.updateOrder(orderDto, ordId), HttpStatus.OK);
    }
    @DeleteMapping("/del/{ordId}")
    private ResponseEntity<String> deleteOrder(@PathVariable("ordId") Integer ordId){
    	return new ResponseEntity<String>(orderService.deleteOrder(ordId),HttpStatus.OK);
    }
    @GetMapping("/getUserOrders/{userId}")
    public List<OrderDto> getOrderByUserId(@PathVariable("userId")Integer userId)
    {
        return orderService.getOrderByUserId(userId);
    }

}