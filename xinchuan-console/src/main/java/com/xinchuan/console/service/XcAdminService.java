package com.xinchuan.console.service;

import com.xinchuan.console.model.XcAdmin;

/**
 * <p>
 *  管理员service
 * </p>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcAdminService.java
 */
public interface XcAdminService {

    XcAdmin findOne(Long id);

    XcAdmin findByName(String name);
}
