package com.xinchuan.console.model;

import com.xinchuan.console.common.SeracherForm;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * <p>
 * 动态管理POJO
 * </p>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcDynamic.java
 */
@Entity
public class XcDynamic extends SeracherForm {

    @Id
    @GeneratedValue
    private Long id;
    private String title;//标题
    private String image;//图片
    private Integer isShow;//是否显示
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;//时间
/*    private String summary;//摘要
    private  String content;//内容*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
