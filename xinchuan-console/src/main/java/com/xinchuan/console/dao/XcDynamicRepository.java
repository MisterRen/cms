package com.xinchuan.console.dao;

import com.xinchuan.console.model.XcDynamic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  动态管理DAO
 * </p>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcDynamicRepository.java
 */
@Repository
public interface XcDynamicRepository extends JpaRepository<XcDynamic,Long> {

    @Query(value = "SELECT * from xc_dynamic d where d.title like %?1% and d.create_time BETWEEN ?2 and ?3 order by d.create_time", nativeQuery = true)
    public List<XcDynamic> findAll(@Param("title")String title,@Param("startTime")String startTime,@Param("endTime")String endTime);
    @Query("SELECT d from XcDynamic d where d.isShow=1 order by d.createTime")
    public List<XcDynamic> findH5List();
    @Query(value = "insert into xc_dynamic(title,image,create_time,is_Show) value(title,image,createTime,isShow)", nativeQuery = true)
    public int saveDynamic(XcDynamic dynamic);
    @Query(value = "update xc_dynamic SET title=?title,image=?image,createTime=?createTime WHERE  id=?id", nativeQuery = true)
    public int updateDynamic(XcDynamic dynamic);
    @Query(value = "update XcDynamic SET isShow=?isShow WHERE  id=?id", nativeQuery = true)
    public int updateStatusDynamic(@Param("isShow") int isShow, @Param("id") Long id);
}
