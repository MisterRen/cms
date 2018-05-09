package com.xinchuan.console.dao;

import com.xinchuan.console.model.XcRecruit;
import org.springframework.data.jpa.repository.JpaRepository;

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
public interface XcRecruitRepository extends JpaRepository<XcRecruit,Long> {
}
