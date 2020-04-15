package com.example.demo.hotGoods.Entity;

import java.util.Date;

public class hotGoodslistEntity {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 热门商品编号
     */
    private String productPop;
    /**
     * 商品编号
     */
    private String skuNo;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 热门排序
     */
    private int popSort;
    /**
     * 商品价格(售价)
     */
    private float sellingPrice;
    /**
     * 商品描述
     */
    private String skudetali;

    /**
     * 作废标记 0为存在，1为作废
     */
    private int is_deleted;
    /**
     * 创建时间
     */
    private Date create_time;
    /**
     * 创建者
     */
    private String create_by;
    /**
     * 更新时间
     */
    private Date gmt_modified;
    /**
     * 更新者
     */
    private String last_modified_by;
    /**
     * 版本号
     */
    private int version;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getProductPop() {
        return productPop;
    }

    public void setProductPop(String productPop) {
        this.productPop = productPop;
    }

    public String getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public int getPopSort() {
        return popSort;
    }

    public void setPopSort(int popSort) {
        this.popSort = popSort;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getSkudetali() {
        return skudetali;
    }

    public void setSkudetali(String skudetali) {
        this.skudetali = skudetali;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public String getLast_modified_by() {
        return last_modified_by;
    }

    public void setLast_modified_by(String last_modified_by) {
        this.last_modified_by = last_modified_by;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
