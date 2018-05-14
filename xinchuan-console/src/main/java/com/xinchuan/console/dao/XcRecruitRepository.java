package com.xinchuan.console.dao;

import com.xinchuan.console.model.XcRecruit;
import com.xinchuan.console.model.XcTeamManage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>
 *  招聘DAO
 * </p>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcRecruitRepository.java
 */
public interface XcRecruitRepository extends JpaRepository<XcRecruit,Long>,JpaSpecificationExecutor<XcRecruit> {
}
