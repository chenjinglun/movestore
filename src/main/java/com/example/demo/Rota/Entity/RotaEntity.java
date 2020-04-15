package com.example.demo.Rota.Entity;

import java.util.Date;

public class RotaEntity {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 商轮播图编号
     */
    private String bannerCode;
    /**
     * 轮播图路径
     */
    private String imageUrl;
    /**
     * 轮播图状态 0启用 1禁用
     */
    private String imageState;
    /**
     * 商品编号
     */
    private String skuNo;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     *  排序
     */
    private int ins;
    /**
     * 有效期起
     */
    private String startTime;
    /**
     * 有效期止
     */
    private String endTime;
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

    public String getBannerCode() {
        return bannerCode;
    }

    public void setBannerCode(String bannerCode) {
        this.bannerCode = bannerCode;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageState() {
        return imageState;
    }

    public void setImageState(String imageState) {
        this.imageState = imageState;
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

    public int getIns() {
        return ins;
    }

    public void setIns(int ins) {
        this.ins = ins;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
