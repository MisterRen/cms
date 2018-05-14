package com.xinchuan.console.dao;

import com.xinchuan.console.model.XcProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

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

    @Query("SELECT p from XcProduct p where p.isShow=1 order by p.level")
    public List<XcProduct> findH5ProductList();
    /*@Query(value = "insert into XcProduct(prodectName,summary,prodectIcon,isShow,level,createTime) value(?prodectName,?summary,?prodectIcon,?isShow,?level,?createTime)", nativeQuery = true)
    public int saveProduct(XcProduct Product);
    @Query(value = "update XcProduct SET prodectName=?prodectName,summary=?summary,prodectIcon=?prodectIcon,createTime=?createTime,isShow=?isShow,level=?isShow WHERE  id=?id", nativeQuery = true)
    public int updateProduct(XcProduct Product);
    @Query(value = "update XcProductc SET isShow=?isShow WHERE  id=?id", nativeQuery = true)
    public int updateStatusProduct(@Param("isShow") int isShow, @Param("id") Long id);*/

}
