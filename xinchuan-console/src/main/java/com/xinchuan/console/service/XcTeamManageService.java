package com.xinchuan.console.service;

import com.xinchuan.console.model.XcTeamManage;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 团队管理service
 * </P>
 * Copyright (C) 2018 东方CJ. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcTeamManageService.java
 */
public interface XcTeamManageService {

    List<XcTeamManage> findAll();

    void saveAndFlush(XcTeamManage xcTeamManage);

    void delAll(String[] ids);

    Optional<XcTeamManage> findById(String id);
}