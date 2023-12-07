package org.model;

public class SectorLimit {


    private String code;

    private Long totalValue;

    private Long buyAmount;

    private Long sellAmount;

    private int allowedRate;



    public SectorLimit(String code, long totalValue,long buyAmount, long sellAmount, int allowedRate) {
        this.code = code;
        this.totalValue = totalValue;
        this.buyAmount = buyAmount;
        this.sellAmount = sellAmount;
        this.allowedRate = allowedRate;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public long getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(long totalValue) {
        this.totalValue = totalValue;
    }

    public long getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(long buyAmount) {
        this.buyAmount = buyAmount;
    }

    public long getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(long sellAmount) {
        this.sellAmount = sellAmount;
    }

    public int getAllowedRate() {
        return allowedRate;
    }

    public void setAllowedRate(int allowedRate) {
        this.allowedRate = allowedRate;
    }

    @Override
    public String toString()
    {
    return "code: "+code+" totalValue: "+totalValue+" buyAmount: "+buyAmount+" sellAmount: "+sellAmount+" allowedRate: "+allowedRate;

    }


}
