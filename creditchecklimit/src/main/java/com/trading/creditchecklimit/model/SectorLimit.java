package com.trading.creditchecklimit.model;

public class SectorLimit {


    private String code;

    private long totalValue;

    private long buyAmount;

    private long remBuyAmount;

    private long sellAmount;

    private long remSellAmount;

    private float allowedRate;



    public SectorLimit(String code, long totalValue, float allowedRate) {
        this.code = code;
        this.totalValue = totalValue;
        this.buyAmount = 0;
        this.sellAmount = 0;
        this.allowedRate = allowedRate;
        this.remSellAmount =(long)(allowedRate/100*totalValue);
        this.remBuyAmount = (long)(allowedRate/100*totalValue);


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

    public float getAllowedRate() {
        return allowedRate;
    }

    public void setAllowedRate(float allowedRate) {
        this.allowedRate = allowedRate;
    }


    public String toString(int side) {
        if (side == 1)
            return //"code:"+code
                    " totalValue:" + totalValue
                            + " allowedRate: " + allowedRate
                            + " buyAmount: " + buyAmount
                            + " remBuyAmount:" + remBuyAmount;

        else

            return //"code:"+code
                    " totalValue:" + totalValue
                            + " allowedRate: " + allowedRate
                            + " sellAmount: " + sellAmount
                            + " remSellAmount:" + remSellAmount;

    }


    public long getRemBuyAmount() {
        return remBuyAmount;
    }

    public void setRemBuyAmount(Long remBuyAmount) {
        this.remBuyAmount = remBuyAmount;
    }

    public long getRemSellAmount() {
        return remSellAmount;
    }

    public void setRemSellAmount(long remSellAmount) {
        this.remSellAmount = remSellAmount;
    }
}
