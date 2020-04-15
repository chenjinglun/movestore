package com.example.demo.goodTypeManger.Entity;

import java.util.Date;

public class goodMangerEntity {

    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 分类编号
     */
    private String cateCode;
    /**
     * 分类名称
     */
    private String cateName;
    /**
     * 父级分类标记 0：一级分类 / 二级分类为对应一级分类编号
     */
    private String cateParent;

    /**
     * 等级
     */
    private int level;
    /**
     * 备注
     */
    private String remark;
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

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public int getLevel() {
        return level;
    }

    public String getCateParent() {
        return cateParent;
    }

    public void setCateParent(String cateParent) {
        this.cateParent = cateParent;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
