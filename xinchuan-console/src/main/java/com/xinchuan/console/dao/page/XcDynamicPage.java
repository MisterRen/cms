package com.xinchuan.console.dao.page;

import com.xinchuan.console.common.BaseSqlDaoImpl;
import com.xinchuan.console.model.PageModel;
import com.xinchuan.console.model.XcDynamic;
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
public class XcDynamicPage extends BaseSqlDaoImpl  {
    public PageModel<XcDynamic> queryDynamicPage(XcDynamic dynamic){
        Map<String,Object> map = new HashMap<String,Object>();
        StringBuilder hql = new StringBuilder();
        hql.append("select t from XcDynamic t where 1=1 ");
        if(dynamic != null){
            if(StringUtils.isNotBlank(dynamic.getTitle())){
                hql.append(" and t.title like :title ");
                map.put("title", "%"+dynamic.getTitle()+"%");
            }

            if(StringUtils.isNotBlank(dynamic.getStartTime())){
                hql.append("and t.createTime >= :startTime ");
                map.put("startTime", dynamic.getStartTime());
            }

            if(StringUtils.isNotBlank(dynamic.getEndTime())){
                hql.append(" and t.createTime <= :endTime ");
                map.put("endTime", dynamic.getEndTime());
            }
        }
        hql.append(" order by t.createTime desc ");
        return this.queryForPageWithParams(hql.toString(),map,dynamic.getCurrentPage(),dynamic.getPageSize());
    }


}
