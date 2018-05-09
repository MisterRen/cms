package com.xinchuan.console.dao;

import com.xinchuan.console.model.XcNews;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 *  新闻DAO
 * </p>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcNewsRepository.java
 */
public interface XcNewsRepository extends JpaRepository<XcNews,Long> {
}
