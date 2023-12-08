package com.trading.creditchecklimit.handler;



import com.trading.creditchecklimit.model.Order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class OrderHandler {

    public static OrderHandler orderManager = null;



    public static OrderHandler getOrderHandler() {
        if(orderManager==null)
            orderManager = new OrderHandler();
        return orderManager;
    }

    int orderNo =0;

    public int getOrderNo()
    {
        orderNo++;
        return orderNo;
    }


    private  List<Order> booked = new ArrayList<>();

    private  LinkedList<Order> queue= new LinkedList<Order>();

    private Vector<String> logger  = new Vector<>();

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


            getBooked().add(order);

        }
        catch (Exception excp)
        {

        }
    }

    public  void print()
    {
        for (Order order: getBooked()
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

    public List<Order> getAllBookings()
    {
        return booked.stream().toList();
    }

    public List<String> getAllLogs()
    {
        return logger.stream().toList();
    }


    public List<Order> getBooked() {
        return booked;
    }


    public List<String> getLogger() {
        return logger;
    }


}
