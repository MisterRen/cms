package com.xinchuan.console.model;

import com.xinchuan.console.common.SeracherForm;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

/**
 * <p>
 * 产品POJO
 * </p>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcProduct.java
 */
@Entity
public class XcProduct extends SeracherForm {

    @Id
    @GeneratedValue
    private Long id;
    private String prodectName;//产品名称
    @Lob
    @Column(columnDefinition="TEXT")
    private String summary;//产品简介
    private String prodectIcon;//产品ICON
    private Integer isShow;//是否显示
    private Integer level;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;//时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdectName() {
        return prodectName;
    }

    public void setProdectName(String prodectName) {
        this.prodectName = prodectName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getProdectIcon() {
        return prodectIcon;
    }

    public void setProdectIcon(String prodectIcon) {
        this.prodectIcon = prodectIcon;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
