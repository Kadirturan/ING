package com.trading.creditchecklimit.service;



import com.trading.creditchecklimit.handler.OrderHandler;
import com.trading.creditchecklimit.handler.SectorLimitHandler;
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

        OrderHandler orderManager = OrderHandler.getOrderHandler();
        SectorLimitHandler sectorManager = SectorLimitHandler.getSectorManager();


        if(sectorManager.checkCreditLimit(order))
        {
            //order.setLimitStatus("accepted");
            orderManager.bookOrderd(order);
            //System.out.println(Thread.currentThread().getName()+" executing:"+order.toString());


            return true;
        }
        //order.setLimitStatus("rejected");
        //System.out.println(Thread.currentThread().getName()+" executing:"+order.toString());
        return false;
    }
}
