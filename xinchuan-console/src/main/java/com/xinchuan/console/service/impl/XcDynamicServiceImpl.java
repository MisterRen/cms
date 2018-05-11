package com.xinchuan.console.service.impl;

import com.xinchuan.console.common.UploadImageUtil;
import com.xinchuan.console.dao.XcDynamicRepository;
import com.xinchuan.console.model.XcDynamic;
import com.xinchuan.console.model.XcTeamManage;
import com.xinchuan.console.service.XcDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import java.io.File;
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
public class XcDynamicServiceImpl implements XcDynamicService {
    @Autowired
    private XcDynamicRepository dynamicRepository;
    private static  String imgPath="\\upload\\company";

    @Override
    public List<XcDynamic> allDynamic(XcDynamic dynamicForm) {
        return dynamicRepository.findAll(dynamicForm.getTitle(),dynamicForm.getStartTime(),dynamicForm.getEndTime());
    }

    @Override
    @Transactional
    public void deleteDynamic(String ids[]) {
        for (String id:ids) dynamicRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public List<XcDynamic> findH5List() {
        return dynamicRepository.findH5List();
    }

    @Override
    @Transactional
    public String saveDynamic(XcDynamic dynamic) {
            try {
                EntityManagerFactory factory= Persistence.createEntityManagerFactory("MyJPA");
                EntityManager em=factory.createEntityManager();
                em.getTransaction().begin();//开始事物
                //Session.save()-->Persist();
                em.persist(dynamic); //持久化到数据库
                em.getTransaction().commit();
                em.close();
                factory.close();
            } catch (Exception e) {
                e.printStackTrace();
                return "保存失败！";
            }
        return null;
    }
    @Override
    public Optional<XcDynamic> findById(String id) {
        Optional<XcDynamic> dynamic=dynamicRepository.findById(Long.valueOf(id));
        return dynamic;
    }

    @Override
    public int updateDynamic(XcDynamic dynamic) {
        return dynamicRepository.updateDynamic(dynamic);
    }

    @Override
    public int updateStatusDynamic(int isShow,Long id) {
        return dynamicRepository.updateStatusDynamic(isShow,id);
    }
}
