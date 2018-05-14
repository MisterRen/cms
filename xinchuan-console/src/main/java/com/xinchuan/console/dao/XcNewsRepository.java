package com.xinchuan.console.dao;

import com.xinchuan.console.model.XcNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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

    @Query("from XcNews a where a.id=:id")
    XcNews findNewsById(@Param("id") Long id);

    @Query("from XcNews a where a.id>:id and isShow=0 order by a.id ")
    List<XcNews> findNewsPrevId(@Param("id") Long id);

    @Query("from XcNews a where a.id<:id and isShow=0 order by a.id desc")
    List<XcNews> findNewsNextId(@Param("id") Long id);

}
