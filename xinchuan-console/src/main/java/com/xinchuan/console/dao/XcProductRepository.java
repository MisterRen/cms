package com.xinchuan.console.dao;

import com.xinchuan.console.model.XcProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 *  产品DAO
 * </p>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcProductRepository.java
 */
public interface XcProductRepository extends JpaRepository<XcProduct,Long> {
}
