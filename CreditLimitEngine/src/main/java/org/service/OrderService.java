package org.service;

import org.managers.OrderManager;
import org.model.Order;

public class OrderService {

    public void acceptOrder(int  side,int volume,String security,String sector,String trader)
    {
        OrderManager orderManager = OrderManager.getOrderManager();

        orderManager.addOrderToQueue(new Order(side,volume,security,sector,trader));

    }
}
