package com.xinchuan.console.service.impl;

import com.xinchuan.console.dao.XcDynamicRepository;
import com.xinchuan.console.dao.page.XcDynamicPage;
import com.xinchuan.console.model.PageModel;
import com.xinchuan.console.model.XcDynamic;
import com.xinchuan.console.service.XcDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * @fileName XcDynamicServiceImpl.java
 */
@Service
public class XcDynamicServiceImpl  implements XcDynamicService{
    @Autowired
    private XcDynamicRepository dynamicRepository;
    @Autowired
    private XcDynamicPage dynamicPage;

    @Override
    public PageModel<XcDynamic>  allDynamic(XcDynamic dynamicForm) {
        return dynamicPage.queryDynamicPage(dynamicForm);
    }

    @Override
    @Transactional
    public void deleteDynamic(String ids[]) {
        for (String id:ids) dynamicRepository.deleteById(Long.valueOf(id));
    }


    @Override
    public List<XcDynamic> findH5List() {
      /*  return dynamicRepository.findH5List();*/
        return null;
    }


    @Override
    @Transactional
    public String saveDynamic(XcDynamic dynamic) {
            try {
                dynamicRepository.save(dynamic);
            } catch (Exception e) {
                e.printStackTrace();
                return "保存失败！";
            }
        return "success";
    }
    @Override
    public Optional<XcDynamic> findById(Long id) {
        Optional<XcDynamic> dynamic=dynamicRepository.findById(id);
        return dynamic;
    }

    @Override
    public String updateDynamic(XcDynamic dynamic) {
        try {
            dynamicRepository.save(dynamic);
        } catch (Exception e) {
            e.printStackTrace();
            return "更新失败！";
        }
        return "success";
    }

}
