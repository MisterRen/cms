package com.xinchuan.console.service;

import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.model.XcNews;

import java.util.Date;
import java.util.List;


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

    PageModel<XcNews> pageQuery(XcNews news);

    void deleteNews(Long id);

    void isEnableNews(XcNews news);

    void saveOrUpdate(XcNews news);

    XcNews findNewsById(Long id);

    List<XcNews> findNewsPrevId(Long id);

    List<XcNews> findNewsNextId(Long id);

}
