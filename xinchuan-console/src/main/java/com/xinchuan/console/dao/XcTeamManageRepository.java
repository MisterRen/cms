package com.xinchuan.console.dao;

import com.xinchuan.console.model.XcTeamManage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 *  团队管理DAO
 * </p>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcTeamManageRepository.java
 */
public interface XcTeamManageRepository extends JpaRepository<XcTeamManage,Long> {
}
