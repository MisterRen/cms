package com.xinchuan.console.service.impl;

import com.xinchuan.console.dao.XcTeamManageRepository;
import com.xinchuan.console.model.XcTeamManage;
import com.xinchuan.console.service.XcTeamManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 * @fileName XcTeamManageServiceImpl.java
 */
@Service
public class XcTeamManageServiceImpl implements XcTeamManageService {
    @Autowired
    XcTeamManageRepository xcTeamManageRepository;

    @Override
    public List<XcTeamManage> findAll() {
        return xcTeamManageRepository.findAll();
    }

    @Override
    public void saveAndFlush(XcTeamManage xcTeamManage){
        xcTeamManageRepository.saveAndFlush(xcTeamManage);
    }

    @Override
    public void delAll(String[] ids) {
        for (String id : ids) {
            xcTeamManageRepository.deleteById(Long.valueOf(id));
        }
    }

    @Override
    public Optional<XcTeamManage> findById(String id) {
        Optional<XcTeamManage> xcTeamManage=xcTeamManageRepository.findById(Long.valueOf(id));
        return xcTeamManage;
    }


}
