package com.dota.database.Dotawiki.controllers;

import com.dota.database.Dotawiki.entity.Order;
import com.dota.database.Dotawiki.entity.OrderProduct;
import com.dota.database.Dotawiki.entity.Product;
import com.dota.database.Dotawiki.repository.OrderProductRepository;
import com.dota.database.Dotawiki.repository.OrderRepository;
import com.dota.database.Dotawiki.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrderHandlingController {

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    private final OrderProductRepository orderProductRepository;

    @Autowired
    public OrderHandlingController(OrderRepository orderRepository, ProductRepository productRepository, OrderProductRepository orderProductRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderProductRepository = orderProductRepository;
    }

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("orders", new Order());
        List<Product> allProducts = productRepository.findAll();
        model.addAttribute("allProducts", allProducts);
        return "homePage";
    }

    @GetMapping("/order/{id}")
    public String orderPage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("order", orderRepository.getOrderById(id));
        return "orderPage";
    }

    @PostMapping("/addOrder")
    public String addOrder(@RequestParam("selectedProducts") List<Long> selectedProductIds) {
        Order order = new Order();
        order.setDate(new Date());
        order.setCost(BigDecimal.ZERO);

        List<OrderProduct> orderProducts = new ArrayList<>();

        for (Long productId : selectedProductIds) {
            Product product = productRepository.findById(productId).orElse(null);
            if (product != null) {
                OrderProduct orderProduct = new OrderProduct();
                orderProduct.setOrder(order);
                orderProduct.setProduct(product);
                orderProducts.add(orderProduct);
                order.setCost(order.getCost().add(product.getCost()));
            }
        }

        order.setProducts(orderProducts);

        orderRepository.save(order);
        orderProductRepository.saveAll(orderProducts);

        return "redirect:/";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/";
    }
}
