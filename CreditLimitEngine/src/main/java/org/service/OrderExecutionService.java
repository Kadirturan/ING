package org.service;

import org.managers.OrderManager;
import org.managers.SectorManager;
import org.model.Order;

import java.util.concurrent.Callable;

public class OrderExecutionService implements Callable<Boolean> {

    private Order order;

    public OrderExecutionService(Order order)
    {
        this.order = order;
    }
    public OrderExecutionService()
    {

    }

    public void setOrder(Order order)
    {
        this.order =order;
    }
    @Override
    public Boolean  call() throws Exception {

        OrderManager orderManager = OrderManager.getOrderManager();

        System.out.println(Thread.currentThread().getName()+" executing:"+order.toString());

       // Thread.sleep(500);
        if(SectorManager.checkCreditLimit(order))
        {
            orderManager.bookOrderd(order);

            return true;
        }
        return false;
    }
}
