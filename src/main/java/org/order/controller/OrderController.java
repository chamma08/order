package org.order.controller;

import org.order.dto.OrderDTO;
import org.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getorders")
    public List<OrderDTO>getOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/getorder/{id}")
    public OrderDTO getOrder(@PathVariable Integer id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/create")
    public OrderDTO create(@RequestBody OrderDTO orderDTO){
        return orderService.create(orderDTO);
    }

    @PutMapping("/update")
    public OrderDTO update(@RequestBody OrderDTO orderDTO){
        return orderService.update(orderDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        return orderService.delete(id);
    }
}
