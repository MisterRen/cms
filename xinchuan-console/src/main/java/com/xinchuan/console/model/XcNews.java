package com.xinchuan.console.model;

import com.xinchuan.console.common.SeracherForm;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 * 新闻管理POJO
 * </p>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcNews.java
 */
@Entity
public class XcNews extends SeracherForm {
    @Id
    @GeneratedValue
    private Long id;
    private String title;//标题
    private String newsImage;//封面
    private Integer isShow;//是否显示
    private Date createTime;//时间
    private String summary;//摘要
    @Lob
    @Column(columnDefinition="TEXT")
    private String content;//内容

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

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
