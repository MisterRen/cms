package com.xinchuan.console.service.impl;

import com.xinchuan.console.common.UploadImageUtil;
import com.xinchuan.console.dao.XcProductRepository;
import com.xinchuan.console.model.XcDynamic;
import com.xinchuan.console.model.XcProduct;
import com.xinchuan.console.service.XcProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 产品service
 * </P>
 * Copyright (C) 2018 东方CJ. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcProductServiceImpl.java
 */
@Service
public class XcProductServiceImpl implements XcProductService {
    @Autowired
    private XcProductRepository productRepository;
    private static  String imgPath="product";

    @Override
    public List<XcProduct> allProduct() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(String[] ids) {
        for (String id:ids) productRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public List<XcProduct> findH5ProductList() {
        return productRepository.findH5ProductList();
    }

    @Override
    public String saveProduct(XcProduct product) {
        try {
            EntityManagerFactory factory= Persistence.createEntityManagerFactory("MyJPA");
            EntityManager em=factory.createEntityManager();
            em.getTransaction().begin();//开始事物
            //Session.save()-->Persist();
            em.persist(product); //持久化到数据库
            em.getTransaction().commit();
            em.close();
            factory.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "保存失败！";
        }
        return "success";
    }

    @Override
    public int updateProduct(XcProduct product) {
        return productRepository.updateProduct(product);
    }

    @Override
    public int updateStatusProduct(int isShow, Long id) {
        return productRepository.updateStatusProduct(isShow,id);
    }

    @Override
    public Optional<XcProduct> findById(String id) {
        Optional<XcProduct> product=productRepository.findById(Long.valueOf(id));
        return product;
    }
}
