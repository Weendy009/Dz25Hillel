package com.dota.database.Dotawiki.repository;


import com.dota.database.Dotawiki.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
