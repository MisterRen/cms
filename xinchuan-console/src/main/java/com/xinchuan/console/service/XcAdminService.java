package com.xinchuan.console.service;

import com.xinchuan.console.model.XcAdmin;

/**
 *
 *
 * </P>
 * Copyright (C) 2018 东方CJ. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcAdminService.java
 */
public interface XcAdminService {

    XcAdmin findOne(Long id);

    XcAdmin findByName(String name);
}
