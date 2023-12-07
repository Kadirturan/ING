package com.trading.creditchecklimit.service;



import com.trading.creditchecklimit.managers.OrderManager;
import com.trading.creditchecklimit.managers.SectorLimitManager;
import com.trading.creditchecklimit.model.Order;

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
        SectorLimitManager sectorManager = SectorLimitManager.getSectorManager();


        if(sectorManager.checkCreditLimit(order))
        {
            order.setLimitStatus("accepted");
            orderManager.bookOrderd(order);
            System.out.println(Thread.currentThread().getName()+" executing:"+order.toString());


            return true;
        }
        order.setLimitStatus("rejected");
        System.out.println(Thread.currentThread().getName()+" executing:"+order.toString());
        return false;
    }
}
