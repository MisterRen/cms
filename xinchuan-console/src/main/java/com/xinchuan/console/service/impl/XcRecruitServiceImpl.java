package com.xinchuan.console.service.impl;

import com.xinchuan.console.dao.XcRecruitRepository;
import com.xinchuan.console.model.XcRecruit;
import com.xinchuan.console.service.XcRecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 招聘service
 * </P>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcRecruitServiceImpl.java
 */
@Service
public class XcRecruitServiceImpl implements XcRecruitService {

    @Autowired
    private XcRecruitRepository xcRecruitRepository;

    @Override
    public Page<XcRecruit> pageQuery(Pageable pageable) {
        return xcRecruitRepository.findAll(pageable);
    }

    @Override
    public void deleteNews(Long id) {
        xcRecruitRepository.deleteById(id);
    }


    @Override
    public void saveOrUpdate(XcRecruit xcRecruit) {
        xcRecruitRepository.save(xcRecruit);
    }
}
