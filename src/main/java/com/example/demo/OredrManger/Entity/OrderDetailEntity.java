package com.example.demo.OredrManger.Entity;

public class OrderDetailEntity {
    /**
     *订单详情编号
     */
    private String orderdeno;
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 商品名字
     */
    private String goodsName;
    /**
     * 成本价
     */
    private float costPrice;
    /**
     *售价
     */
    private float salesPrice;
    /**
     * 数量
     */
    private int num;
    /**
     * 用户ID
     */
    private String userCode;

    /**
     *总价
     */
    private float totalMoney;

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getOrderdeno() {
        return orderdeno;
    }

    public void setOrderdeno(String orderdeno) {
        this.orderdeno = orderdeno;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public float getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(float salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
