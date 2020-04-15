package com.example.demo.StoreInfomation.Entity;

import java.util.Date;

public class StoreInEntity {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 门店编号
     */
    private int storeNO;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 详细地址
     */
    private String storeAddress;
    /**
     * 门店电话
     */
    private String storePhone;
    /**
     * 店长用户编号
     */
    private String userCode;
    /**
     * 营业执照
     */
    private String storeLicense;
    /**
     * 店铺邀请码
     */
    private String storeInvitation;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String county;
    /**
     * 店长姓名
     */
    private String storeUserName;
    /**
     * 店长账号
     */
    private String storeAcct;
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

    public int getStoreNO() {
        return storeNO;
    }

    public void setStoreNO(int storeNO) {
        this.storeNO = storeNO;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getStoreLicense() {
        return storeLicense;
    }

    public void setStoreLicense(String storeLicense) {
        this.storeLicense = storeLicense;
    }

    public String getStoreInvitation() {
        return storeInvitation;
    }

    public void setStoreInvitation(String storeInvitation) {
        this.storeInvitation = storeInvitation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
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

    public String getStoreUserName() {
        return storeUserName;
    }

    public void setStoreUserName(String storeUserName) {
        this.storeUserName = storeUserName;
    }
    public String getStoreAcct() {
        return storeAcct;
    }

    public void setStoreAcct(String storeAcct) {
        this.storeAcct = storeAcct;
    }

}
