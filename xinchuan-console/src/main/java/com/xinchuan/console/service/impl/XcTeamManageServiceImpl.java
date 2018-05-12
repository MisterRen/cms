package com.xinchuan.console.service.impl;

import com.xinchuan.console.dao.XcTeamManageRepository;
import com.xinchuan.console.dao.page.XcTeamManagePage;
import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.model.XcProduct;
import com.xinchuan.console.model.XcTeamManage;
import com.xinchuan.console.service.XcTeamManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 团队管理service
 * </P>
 * Copyright (C) 2018 东方CJ. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcTeamManageServiceImpl.java
 */
@Service
public class XcTeamManageServiceImpl implements XcTeamManageService {
    @Autowired
    private XcTeamManageRepository xcTeamManageRepository;
    @Autowired
    private XcTeamManagePage xcTeamManagePage;

    @Override
    public PageModel<XcTeamManage> allXcTeamManage(XcTeamManage xcTeamManage) {
        return xcTeamManagePage.queryXcTeamManagePage(xcTeamManage);
    }
    @Override
    public void isEnableNews(XcTeamManage teamManage) {
        XcTeamManage xcTeamManage = xcTeamManageRepository.findById(teamManage.getId()).get();
        xcTeamManage.setIsShow(teamManage.getIsShow());
        xcTeamManageRepository.saveAndFlush(xcTeamManage);
    }
    @Override
    public List<XcTeamManage> findAll() {
        return xcTeamManageRepository.findAll();
    }

    @Override
    public void saveAndFlush(XcTeamManage xcTeamManage){
        xcTeamManageRepository.saveAndFlush(xcTeamManage);
    }

    @Override
    public void delOne(Long id) {
            xcTeamManageRepository.deleteById(id);
    }

    @Override
    public Optional<XcTeamManage> findById(String id) {
        Optional<XcTeamManage> xcTeamManage=xcTeamManageRepository.findById(Long.valueOf(id));
        return xcTeamManage;
    }

    @Override
    public List<XcTeamManage> findByCreateTimeAndName(String startDate, String endDate, String name) {
        List<XcTeamManage> resultList = null;
        Specification querySpecifi = new Specification<XcTeamManage>() {
            @Override
            //root参数是我们用来对应实体的信息的。criteriaBuilder可以帮助我们制作查询信息。
            //如果有多个条件，我们就可以创建一个Predicate集合，最后用CriteriaBuilder的and和or方法进行组合，得到最后的Predicate对象。
            public Predicate toPredicate(Root<XcTeamManage> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(startDate.length()!=0 || endDate.length()!=0){
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
                    try {
                        Date sDate=sdf.parse(startDate);
                        Date eDate=sdf.parse(endDate);
                        predicates.add(criteriaBuilder.between(root.get("createTime"), sDate,eDate));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                if(name.length()!=0){
                    predicates.add(criteriaBuilder.like(root.get("name"), "%"+name+"%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        resultList =  xcTeamManageRepository.findAll(querySpecifi);
        return resultList;
    }

    @Override
    public void saveOrUpdate(XcTeamManage xcTeamManage) {
        xcTeamManageRepository.save(xcTeamManage);
    }


}
