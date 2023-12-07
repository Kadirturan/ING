package com.trading.creditchecklimit.managers;



import com.trading.creditchecklimit.model.Order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderManager {

    public static OrderManager orderManager = null;



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

    public  synchronized void addOrdersToQueue(List<Order> orderList)
    {

        queue.addAll(orderList);
    }

    public  synchronized Order getOrderToExecute()
    {
        return queue.poll();
    }

    public  void bookOrderd(Order order)
    {
        try {


            booked.add(order);

        }
        catch (Exception excp)
        {

        }
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

    public List<Order> getAllWaitingOrder()
    {
        return queue.stream().toList();
    }


}
