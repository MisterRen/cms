package com.xinchuan.console.service.impl;

import com.xinchuan.console.dao.XcAdminRepository;
import com.xinchuan.console.model.XcAdmin;
import com.xinchuan.console.service.XcAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <p>
 *
 * </p>
 * Copyright (C) 2018 东方CJ. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcAdminServiceImpl.java
 */
@Service
public class XcAdminServiceImpl implements XcAdminService {

    @Autowired
    private XcAdminRepository xcAdminRepository;

    @Override
    public XcAdmin findOne(Long id) {
        return xcAdminRepository.findById(id).get();
    }

    @Override
    public XcAdmin findByName(String name) {
        return xcAdminRepository.findByName(name);
    }
    @Override
    public XcAdmin login(String name,String password) {
        return xcAdminRepository.login(name,password);
    }
}
