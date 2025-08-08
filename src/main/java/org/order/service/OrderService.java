package org.order.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.order.dto.OrderDTO;
import org.order.model.Order;
import org.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderRepo orderRepo;

    public List<OrderDTO> getOrders(){
        List<Order>orderList = orderRepo.findAll();
        return modelMapper.map(orderList,new TypeToken<List<OrderDTO>>(){}.getType());
    }

    public OrderDTO create(OrderDTO orderDTO){
        orderRepo.save(modelMapper.map(orderDTO,Order.class));
        return orderDTO;
    }

    public OrderDTO getOrderById(Integer id){
        Order order = orderRepo.getOrderById(id);
        return modelMapper.map(order,OrderDTO.class);
    }

    public OrderDTO update(OrderDTO orderDTO){
        orderRepo.save(modelMapper.map(orderDTO,Order.class));
        return orderDTO;
    }

    public String delete(Integer id){
        orderRepo.deleteById(id);
        return "Deleted";
    }

}
