package com.xinchuan.console.service;

import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.model.XcConsult;

/**
 * <p>
 * 联系我们service
 * </P>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcConsultService.java
 */
public interface XcConsultService {

    PageModel<XcConsult> pageQuery(XcConsult consultForm);

    void deleteNews(Long id);

    void isEnableNews(XcConsult xcConsult);

    void saveOrUpdate(XcConsult xcConsult);
}
