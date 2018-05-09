package com.xinchuan.console.dao;

import com.xinchuan.console.model.XcAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 管理员DAO
 * </p>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcAdminRepository.java
 */
@Repository
public interface XcAdminRepository extends JpaRepository<XcAdmin,Long> {

    @Query("from XcAdmin a where a.adminNme=:name and a.adminPwd=:password")
    XcAdmin findByName(@Param("name") String name);
}
