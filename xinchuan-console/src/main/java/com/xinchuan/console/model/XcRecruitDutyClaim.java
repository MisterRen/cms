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
 * @fileName XcRecruitRequireClaim.java
 */
@Entity
public class XcRecruitDutyClaim {

    @Id
    private Long id;

    @ManyToOne(targetEntity = XcRecruit.class)
    @JoinColumn(name="duty")
    private XcRecruit dutyId;

    private String dutyClaim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public XcRecruit getDutyId() {
        return dutyId;
    }

    public void setDutyId(XcRecruit dutyId) {
        this.dutyId = dutyId;
    }

    public String getDutyClaim() {
        return dutyClaim;
    }

    public void setDutyClaim(String dutyClaim) {
        this.dutyClaim = dutyClaim;
    }
}
