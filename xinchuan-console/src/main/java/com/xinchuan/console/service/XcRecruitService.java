package com.xinchuan.console.service;

import com.xinchuan.console.model.XcRecruit;
import com.xinchuan.console.model.XcRecruitOld;
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
    List<XcRecruitOld> findAll();

    void saveAndFlush(XcRecruitOld xcRecruitOld);

    void delAll(String[] ids);

    Optional<XcRecruitOld> findById(String id);

    List<XcRecruitOld> findByCreateTimeAndName(String startDate,String endDate,String name);

    void saveOrUpdate(XcRecruitOld xcRecruitOld);
}
