package com.xinchuan.console.service.impl;

import com.xinchuan.console.common.AjaxMsg;
import com.xinchuan.console.dao.XcNewsRepository;
import com.xinchuan.console.model.XcNews;
import com.xinchuan.console.service.XcNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;


/**
 * <p>
 * 新闻service
 * </P>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcNewsServiceImpl.java
 */
@Service
public class XcNewsServiceImpl implements XcNewsService {

    @Autowired
    private XcNewsRepository xcNewsRepository;

    @Override
    public Page<XcNews> pageQuery(Pageable pageable) {
        return xcNewsRepository.findAll(pageable);
    }

    @Override
    public void deleteNews(Long id) {
        xcNewsRepository.deleteById(id);
    }

    @Override
    public void isEnableNews(XcNews news) {
        XcNews xcNews = xcNewsRepository.findById(news.getId()).get();
        xcNews.setIsShow(news.getIsShow());
        xcNewsRepository.saveAndFlush(xcNews);
    }
}
