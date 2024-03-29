package com.trading.creditchecklimit.model;


import com.trading.creditchecklimit.handler.OrderHandler;


public class Order {
    private int orderNo;
    private int  side; //1 buy ,2 sell
    private int volume;

    private String security;

    private String sector;

    private String trader;

    private String status;



    public Order(int side,int volume,String security,String sector,String trader)
    {
        OrderHandler orderManager = OrderHandler.getOrderHandler();
        orderNo=orderManager.getOrderNo();
        this.side=side;
        this.volume=volume;
        this.security=security;
        this.sector=sector;
        this.trader=trader;
        this.status="";
    }




    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    @Override
    public String toString()
    {
        return "orderNo:"+ getOrderNo()
                +" side:"+side
                +" volume: "+volume
                //+" security: "+security
                 +" sector:"+sector
                //+" trader: "+trader
                +" status:"+ status;

    }

    public int getOrderNo() {
        return orderNo;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
