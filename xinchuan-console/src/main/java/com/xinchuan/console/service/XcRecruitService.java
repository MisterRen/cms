package com.xinchuan.console.service;

import com.xinchuan.console.model.XcRecruit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * <p>
 * 招聘service
 * </P>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcRecruitService.java
 */
public interface XcRecruitService {

    Page<XcRecruit> pageQuery(Pageable pageable);

    void deleteNews(Long id);


    void saveOrUpdate(XcRecruit xcRecruit);
}
