package com.trading.creditchecklimit.managers;



import com.trading.creditchecklimit.model.Order;
import com.trading.creditchecklimit.model.SectorLimit;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SectorLimitManager {

    private static SectorLimitManager sectorManager = null;

    public static SectorLimitManager getSectorManager()
    {
        if(sectorManager==null)
            sectorManager = new SectorLimitManager();
        return sectorManager;
    }
    public  Map<String, SectorLimit> sectorLimitMap = new ConcurrentHashMap<>();






    public   boolean checkCreditLimit(Order order)
    {
        SectorLimit limit = sectorLimitMap.get(order.getSector());
        if(limit==null)
            return true;
        else {
            if(order.getSide()==1) //buy order
            {
                float buyPercentage = ((float)(order.getVolume()+limit.getBuyAmount())/limit.getTotalValue())*100;
                if(buyPercentage<limit.getAllowedRate())
                {
                    limit.setBuyAmount(limit.getBuyAmount()+order.getVolume());
                    return true;
                }
                else
                    return false;
            }
            else if(order.getSide()==2) //sell order
            {
                float sellPercentage = ((float)(order.getVolume()+limit.getSellAmount())/limit.getTotalValue())*100;
                if(sellPercentage<limit.getAllowedRate())
                {
                    limit.setSellAmount(limit.getSellAmount()+order.getVolume());
                    return true;
                }
                else
                    return false;
            }
            return false;

        }

    }

    public  void printMap()
    {
        for(Map.Entry<String,SectorLimit> enty:sectorLimitMap.entrySet())
        {
            System.out.println(enty.getValue().toString());
        }
    }

    public void addSectorLimits(List<SectorLimit> sectorLimitList)
    {
        for(SectorLimit sectorLimit :sectorLimitList)
        sectorLimitMap.put(sectorLimit.getCode(),sectorLimit);
    }


}
