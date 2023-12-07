package com.trading.creditchecklimit.contoller;

import com.trading.creditchecklimit.model.Order;
import com.trading.creditchecklimit.service.OrderService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public void enterOrder(@RequestBody Order order)
    {
        orderService.acceptOrder(order);

    }



    @GetMapping( value = "/allorders",  produces = "application/json")
    public List<Order> getAllOrders() {

        return orderService.getAllWaitingOrder();
    }
}
