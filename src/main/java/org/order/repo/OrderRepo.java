package org.order.repo;

import org.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {
    @Query(value = "SELECT * FROM Order WHERE Id = ?1",nativeQuery = true)
    Order getOrderById(Integer id);
}
