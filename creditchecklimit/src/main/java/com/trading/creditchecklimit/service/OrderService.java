package com.trading.creditchecklimit.service;


import com.trading.creditchecklimit.data.InitialData;
import com.trading.creditchecklimit.managers.OrderManager;
import com.trading.creditchecklimit.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    OrderManager orderManager = OrderManager.getOrderManager();
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
}
