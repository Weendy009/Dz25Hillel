package com.dota.database.Dotawiki.repository;

import com.dota.database.Dotawiki.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order getOrderById(Long id);

    List<Order> findAll();

}
