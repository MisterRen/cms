package com.xinchuan.console.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

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
    private String duty;//职责
    private Integer requirements;//要求
    private Date createTime;//时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getRequirements() {
        return requirements;
    }

    public void setRequirements(Integer requirements) {
        this.requirements = requirements;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
