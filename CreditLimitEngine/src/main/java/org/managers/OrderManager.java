package org.managers;

import org.model.Order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OrderManager {

    public static OrderManager orderManager = null;

    private OrderManager()
    {

    }

    public static OrderManager getOrderManager() {
        if(orderManager==null)
            orderManager = new OrderManager();
        return orderManager;
    }

    int orderNo =0;

    public int getOrderNo()
    {
        orderNo++;
        return orderNo;
    }


    public  List<Order> booked = new ArrayList<>();

    private  LinkedList<Order> queue= new LinkedList<Order>();

    public  synchronized void addOrderToQueue(Order order)
    {

        queue.add(order);
    }

    public  synchronized Order getOrderToExecute()
    {
        return queue.poll();
    }

    public  void bookOrderd(Order order)
    {
        booked.add(order);
    }

    public  void print()
    {
        for (Order order: booked
             ) {
            System.out.println(order.toString());

        }
    }

    public  boolean isQueueEmpty()
    {
        return  queue.isEmpty();
    }


}
