package com.xinchuan.console.service.impl;

import com.xinchuan.console.dao.XcRecruitRepository;
import com.xinchuan.console.model.XcRecruit;
import com.xinchuan.console.model.XcTeamManage;
import com.xinchuan.console.service.XcRecruitService;
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
    XcRecruitRepository xcRecruitRepository;
    @Override
    public List<XcRecruit> findAll() {
        return xcRecruitRepository.findAll();
    }

    @Override
    public void saveAndFlush(XcRecruit xcRecruitOld){
        xcRecruitRepository.saveAndFlush(xcRecruitOld);
    }

    @Override
    public void delAll(String[] ids) {
        for (String id : ids) {
            xcRecruitRepository.deleteById(Long.valueOf(id));
        }
    }

    @Override
    public Optional<XcRecruit> findById(String id) {
        Optional<XcRecruit> xcRecruitOld=xcRecruitRepository.findById(Long.valueOf(id));
        return xcRecruitOld;
    }

    @Override
    public List<XcRecruit> findByCreateTimeAndName(String startDate, String endDate, String postName) {
        List<XcRecruit> resultList = null;
        Specification querySpecifi = new Specification<XcRecruit>() {
            @Override
            //root参数是我们用来对应实体的信息的。criteriaBuilder可以帮助我们制作查询信息。
            //如果有多个条件，我们就可以创建一个Predicate集合，最后用CriteriaBuilder的and和or方法进行组合，得到最后的Predicate对象。
            public Predicate toPredicate(Root<XcRecruit> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
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
                if(postName.length()!=0){
                    predicates.add(criteriaBuilder.like(root.get("postName"), "%"+postName+"%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        resultList =  xcRecruitRepository.findAll(querySpecifi);
        return resultList;
    }

    @Override
    public void saveOrUpdate(XcRecruit xcRecruit) {
        xcRecruitRepository.save(xcRecruit);
    }
}
