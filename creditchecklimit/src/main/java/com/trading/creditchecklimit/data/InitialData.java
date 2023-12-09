package com.trading.creditchecklimit.data;

import com.trading.creditchecklimit.handler.OrderHandler;
import com.trading.creditchecklimit.handler.SectorLimitHandler;
import com.trading.creditchecklimit.model.Order;
import com.trading.creditchecklimit.model.SectorLimit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class InitialData {

     static String []securityList = new String[]{"AKBNK","YKBNK","GARAN","ISBNK"};
    static String []sectorList = new String[]{"Health","Banking","Food"};

    static String []traderList = new String[]{"TRD1","TRD2","TRD3"};

    static Random random = new Random();

    private static List<SectorLimit> sectorLimitList =  Arrays.asList(
            new SectorLimit(sectorList[0],random.nextInt(100000,500000),random.nextInt(25,70)),
            new SectorLimit(sectorList[1],random.nextInt(100000,500000),random.nextInt(25,70)),
            new SectorLimit(sectorList[2],random.nextInt(100000,500000),random.nextInt(25,70)));

    private static List<Order> getInitialOrders()
    {
        List<Order> orderList = new ArrayList<>();


        for(int i=0;i<100;i++)
        {
            orderList.add(new Order(
                  random.nextInt(1,3),
                  random.nextInt(1000,100000),
                    securityList[random.nextInt(0,securityList.length)],
                    sectorList[random.nextInt(0,sectorList.length)],
                    traderList[random.nextInt(0,traderList.length)]
            ));
            //System.out.println(orderList.get(i).getSide()+";"+orderList.get(i).getVolume()+";"+orderList.get(i).getSecurity()+";"+orderList.get(i).getSector()+";"+orderList.get(i).getTrader());
        }

        return orderList;
    }

    public static void loadRandomValues()
    {
        SectorLimitHandler sectorManager = SectorLimitHandler.getSectorLimitHandler();
        sectorManager.addSectorLimits(sectorLimitList);
        OrderHandler orderManager = OrderHandler.getOrderHandler();
        orderManager.addOrdersToQueue(getInitialOrders());
    }



    public static void loadFromFile()
    {
        SectorLimitHandler sectorLimitHandler = SectorLimitHandler.getSectorLimitHandler();
        OrderHandler orderHandler = OrderHandler.getOrderHandler();


        try{

            List<String> sectors = Files.readAllLines(Paths.get("src/main/resources/sector.csv"));

            //Read from the stream
            String [] sectorArray = null;
            for(String sector:sectors){//for each line of content in contents
                sectorArray = sector.split(";");
                sectorLimitHandler.addSectorLimit(new SectorLimit(sectorArray[0],Long.valueOf(sectorArray[1]),Float.valueOf(sectorArray[2])));


            }

            String [] orderArray = null;
            List<String> orders = Files.readAllLines(Paths.get("src/main/resources/order.csv"));
            for(String order:orders){//for each line of content in contents
                orderArray = order.split(";");
                orderHandler.addOrderToQueue(new Order(Integer.parseInt(orderArray[0]),Integer.parseInt(orderArray[1]),orderArray[2],orderArray[3],orderArray[4]));



            }

        }catch(IOException ex){
            ex.printStackTrace();//handle exception here
        }
    }


}
