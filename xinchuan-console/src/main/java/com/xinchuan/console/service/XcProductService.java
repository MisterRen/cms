package com.xinchuan.console.service;
import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.model.XcDynamic;
import com.xinchuan.console.model.XcProduct;

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
 * @fileName XcProductService.java
 */
public interface XcProductService {
    public PageModel<XcProduct> allProduct(XcProduct productForm);

    void delOne(Long id);

    public List<XcProduct> findH5ProductList();

    String saveProduct(XcProduct product);

    void isEnableNews(XcProduct product);

    public String updateProduct(XcProduct product);

    int updateStatusProduct(int isShow, Long id);

     Optional<XcProduct> findById(Long id);
}
