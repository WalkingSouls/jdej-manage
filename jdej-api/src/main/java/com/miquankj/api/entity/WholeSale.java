package com.miquankj.api.entity;

public class WholeSale {
    private Integer saleId;

    private Integer productId;

    private Integer startAmount;

    private Long startPrice;

    private Integer intervalStart;

    private Integer intervalEnd;

    private Long intervalPrice;

    private Integer maxAmount;

    private Long maxDiscPrice;

    private Byte valid;

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(Integer startAmount) {
        this.startAmount = startAmount;
    }

    public Long getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Long startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getIntervalStart() {
        return intervalStart;
    }

    public void setIntervalStart(Integer intervalStart) {
        this.intervalStart = intervalStart;
    }

    public Integer getIntervalEnd() {
        return intervalEnd;
    }

    public void setIntervalEnd(Integer intervalEnd) {
        this.intervalEnd = intervalEnd;
    }

    public Long getIntervalPrice() {
        return intervalPrice;
    }

    public void setIntervalPrice(Long intervalPrice) {
        this.intervalPrice = intervalPrice;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Long getMaxDiscPrice() {
        return maxDiscPrice;
    }

    public void setMaxDiscPrice(Long maxDiscPrice) {
        this.maxDiscPrice = maxDiscPrice;
    }

    public Byte getValid() {
        return valid;
    }

    public void setValid(Byte valid) {
        this.valid = valid;
    }
}