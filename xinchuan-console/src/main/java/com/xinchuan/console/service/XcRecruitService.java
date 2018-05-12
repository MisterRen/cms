package com.xinchuan.console.service;

import com.xinchuan.console.model.XcRecruit;
import com.xinchuan.console.model.XcTeamManage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 招聘service
 * </P>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcRecruitService.java
 */
public interface XcRecruitService {
    //XcRecruitOld
    List<XcRecruit> findAll();

    void saveAndFlush(XcRecruit xcRecruit);

    void delAll(String[] ids);

    Optional<XcRecruit> findById(String id);

    List<XcRecruit> findByCreateTimeAndName(String startDate,String endDate,String name);

    void saveOrUpdate(XcRecruit xcRecruit);
}
