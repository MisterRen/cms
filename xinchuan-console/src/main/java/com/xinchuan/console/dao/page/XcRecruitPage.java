package com.xinchuan.console.dao.page;

import com.xinchuan.console.common.BaseSqlDaoImpl;
import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.model.XcRecruit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  动态管理DAO
 * </p>
 * Copyright (C) 2018 信传. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月09日)
 * @version 1.0
 * @fileName XcDynamicRepository.java
 */
@Service
public class XcRecruitPage extends BaseSqlDaoImpl  {
    public PageModel<XcRecruit> queryXcRecruitPage(XcRecruit recruit){
        Map<String,Object> map = new HashMap<String,Object>();
        StringBuilder hql = new StringBuilder();
        hql.append("select t from XcRecruit t where 1=1 ");
        if(recruit != null){
            if(recruit.getIsShow()!=null){
                hql.append(" and t.isShow =:isShow");
                map.put("isShow", +recruit.getIsShow());
            }
            if(StringUtils.isNotBlank(recruit.getPostName())){
                hql.append(" and t.postName like :name ");
                map.put("name", "%"+recruit.getPostName()+"%");
            }

            if(StringUtils.isNotBlank(recruit.getStartTime())){
                hql.append("and t.createTime >= :startTime ");
                map.put("startTime", recruit.getStartTime());
            }

            if(StringUtils.isNotBlank(recruit.getEndTime())){
                hql.append(" and t.createTime <= :endTime ");
                map.put("endTime", recruit.getEndTime());
            }
        }
        hql.append(" order by t.createTime desc ");
        return this.queryForPageWithParams(hql.toString(),map,recruit.getCurrentPage(),recruit.getPageSize());
    }


}
