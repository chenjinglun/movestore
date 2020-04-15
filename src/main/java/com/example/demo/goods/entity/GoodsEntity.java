package com.example.demo.goods.entity;

import java.util.Date;

public class GoodsEntity {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品售价
     */
    private String sellingPrice;
    /**
     * 成本价
     */
    private String costPrice;
    /**
     *  商品销售量
     */
    private String saleCnt;
    /**
     * 一级分类编码
     */
    private String onecatecode;
    /**
     * 二级分类编码
     */
    private String twocatecode;
    /**
     * 广告词
     */
    private String detail;
    /**
     * 商品介绍
     */
    private String skudetail;
    /**
     * 商品状态(0售罄，1在售，2已下架，3未发布)
     */
    private String skuState;
    /**
     * 商品发售时间
     */
    private Date saleTime;
    /**
     * 商品下架时间
     */
    private String saleOuttime;
    /**
     * 商家编码
     */
    private String userCode;
    /**
     * 出版社
     */
    private String skuPress;
    /**
     * 库存
     */
    private String stock;
    /**
     * 作者
     */
    private String AuthorName;
    /**
     * 书号
     */
    private String bookNo;
    /**
     * 图片路径
     */
    private String imageCode;
    /**
     * 商家名称
     */
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
    /**
     * 商家名字
     */
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getSaleCnt() {
        return saleCnt;
    }

    public void setSaleCnt(String saleCnt) {
        this.saleCnt = saleCnt;
    }

    public String getOnecatecode() {
        return onecatecode;
    }

    public void setOnecatecode(String onecatecode) {
        this.onecatecode = onecatecode;
    }

    public String getTwocatecode() {
        return twocatecode;
    }

    public void setTwocatecode(String twocatecode) {
        this.twocatecode = twocatecode;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSkudetail() {
        return skudetail;
    }

    public void setSkudetail(String skudetail) {
        this.skudetail = skudetail;
    }

    public String getSkuState() {
        return skuState;
    }

    public void setSkuState(String skuState) {
        this.skuState = skuState;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public String getSaleOuttime() {
        return saleOuttime;
    }

    public void setSaleOuttime(String saleOuttime) {
        this.saleOuttime = saleOuttime;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getSkuPress() {
        return skuPress;
    }

    public void setSkuPress(String skuPress) {
        this.skuPress = skuPress;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
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
