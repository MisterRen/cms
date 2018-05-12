package com.xinchuan.console.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 招聘POJO
 * </p>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcRecruit.java
 */
@Entity
public class XcRecruit {

    @Id
    @GeneratedValue
    private Long id;
    private String postName;//岗位名称
    @Lob
    @Column(columnDefinition="TEXT")
    private String duty;//职责
    @Lob
    @Column(columnDefinition="TEXT")
    private String requirements;//要求
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;//时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
}
