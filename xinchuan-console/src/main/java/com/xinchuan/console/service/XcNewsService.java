package com.xinchuan.console.service;

import com.xinchuan.console.common.AjaxMsg;
import com.xinchuan.console.model.XcNews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * <p>
 * 新闻service
 * </P>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcNewsService.java
 */
public interface XcNewsService {

    Page<XcNews> pageQuery(Pageable pageable);

    void deleteNews(Long id);

    void isEnableNews(XcNews news);
}
