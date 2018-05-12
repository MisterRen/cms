package com.xinchuan.console.model;

import javax.persistence.*;

/**
 * <p>
 * 招聘要求项
 * </p>
 * Copyright (C) 2018 东方CJ. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月11日)
 * @version 1.0
 * @fileName .java
 */
@Entity
public class XcRecruitRequireClaim {

    @Id
    private Long id;

    @ManyToOne(targetEntity = XcRecruit.class)
    @JoinColumn(name="requirements")
    private XcRecruit requireId;

    private String requireClaim;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequireClaim() {
        return requireClaim;
    }

    public void setRequireClaim(String requireClaim) {
        this.requireClaim = requireClaim;
    }

    public XcRecruit getRequireId() {
        return requireId;
    }

    public void setRequireId(XcRecruit requireId) {
        this.requireId = requireId;
    }
}
