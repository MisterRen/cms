package com.xinchuan.console.service.impl;

import com.xinchuan.console.dao.XcProductRepository;
import com.xinchuan.console.dao.page.XcProductPage;
import com.xinchuan.console.model.PageModel;
import com.xinchuan.console.model.XcProduct;
import com.xinchuan.console.service.XcProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class XcProductServiceImpl  implements XcProductService {
    @Autowired
    private XcProductRepository productRepository;

    @Autowired
    private XcProductPage productPage;

    @Override
    public PageModel<XcProduct> allProduct(XcProduct productForm) {
        return productPage.queryXcProductPage(productForm);
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
            productRepository.save(product);
        } catch (Exception e) {
            e.printStackTrace();
            return "保存失败！";
        }
        return "success";
    }

    @Override
    public String updateProduct(XcProduct product) {
        try {
            productRepository.save(product);
        } catch (Exception e) {
            e.printStackTrace();
            return "更新失败！";
        }
        return "success";
    }

    @Override
    public int updateStatusProduct(int isShow, Long id) {
        return 0;
    }

    @Override
    public Optional<XcProduct> findById(String id) {
        Optional<XcProduct> product=productRepository.findById(Long.valueOf(id));
        return product;
    }
}
