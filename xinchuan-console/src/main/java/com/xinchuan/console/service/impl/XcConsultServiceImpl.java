package com.xinchuan.console.service.impl;

import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.dao.XcConsultRepository;
import com.xinchuan.console.dao.page.XcConsultPage;
import com.xinchuan.console.model.XcConsult;
import com.xinchuan.console.service.XcConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 联系我们service
 * </P>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcConsultServiceImpl.java
 */
@Service
public class XcConsultServiceImpl implements XcConsultService {

    @Autowired
    private XcConsultRepository xcConsultRepository;
    @Autowired
    private XcConsultPage consultPage;

    @Override
    public PageModel<XcConsult> pageQuery(XcConsult consultForm) {
        return consultPage.queryXcConsultPage(consultForm);
    }

    @Override
    public void deleteNews(Long id) {
        xcConsultRepository.deleteById(id);
    }

    @Override
    public void isEnableNews(XcConsult xcConsult) {
        XcConsult saveBody = xcConsultRepository.findById(xcConsult.getId()).get();
        if(xcConsult.getStatus() == 0)
            saveBody.setStatus(1);
        xcConsultRepository.saveAndFlush(saveBody);
    }

    @Override
    public void saveOrUpdate(XcConsult xcConsult) {
        xcConsultRepository.save(xcConsult);
    }
}
