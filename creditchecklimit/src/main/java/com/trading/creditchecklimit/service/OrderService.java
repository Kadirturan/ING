package com.trading.creditchecklimit.service;


import com.trading.creditchecklimit.handler.OrderHandler;
import com.trading.creditchecklimit.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    OrderHandler orderManager = OrderHandler.getOrderHandler();
    public void acceptOrder(int  side,int volume,String security,String sector,String trader)
    {


        orderManager.addOrderToQueue(new Order(side,volume,security,sector,trader));

    }

    public void acceptOrder(Order order)
    {


        orderManager.addOrderToQueue(order);

    }



    public List<Order> getAllWaitingOrder()
    {
        return orderManager.getAllWaitingOrder();
    }

    public List<Order> getAllBookings()
    {
        return orderManager.getAllBookings();
    }

    public List<String> getAllLogs()
    {
        return orderManager.getAllLogs();
    }
}
