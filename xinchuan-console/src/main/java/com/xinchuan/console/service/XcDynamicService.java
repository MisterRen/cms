package com.xinchuan.console.service;

import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.model.XcDynamic;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 动态管理service
 * </P>
 * Copyright (C) 2018 东方CJ. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcDynamicService.java
 */
public interface XcDynamicService {
    public PageModel<XcDynamic> allDynamic(XcDynamic dynamic);

    public  void delOne(Long id);

    public List<XcDynamic> findH5List();

    void isEnableNews(XcDynamic dynamic);

    String saveDynamic(XcDynamic dynamic);

    String updateDynamic(XcDynamic dynamic);

    Optional<XcDynamic> findById(Long id);

}
