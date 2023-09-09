package com.dota.database.Dotawiki.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private BigDecimal cost;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> products;

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                ", cost=" + cost +
                '}';
    }

}
