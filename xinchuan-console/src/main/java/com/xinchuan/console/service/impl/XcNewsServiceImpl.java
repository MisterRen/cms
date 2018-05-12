package com.xinchuan.console.service.impl;

import com.xinchuan.console.common.AjaxMsg;
import com.xinchuan.console.dao.XcNewsRepository;
import com.xinchuan.console.dao.page.XcNewsPage;
import com.xinchuan.console.model.PageModel;
import com.xinchuan.console.model.XcNews;
import com.xinchuan.console.service.XcNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.Optional;


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
    @Autowired
    private XcNewsPage newsPage;

    @Override
    public PageModel<XcNews> pageQuery(XcNews news) {
        return newsPage.queryXcNewsPage(news);
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

    @Override
    public void saveOrUpdate(XcNews news) {
        xcNewsRepository.save(news);
    }

    @Override
    public XcNews findNewsById(Long id) {
        XcNews xcNews = xcNewsRepository.findNewsById(id);
        if(xcNews == null){
            return new XcNews();
        }
        return xcNews;
    }
}
