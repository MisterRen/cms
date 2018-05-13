package com.xinchuan.console.dao.page;

import com.xinchuan.console.common.BaseSqlDaoImpl;
import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.model.XcNews;
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
public class XcNewsPage extends BaseSqlDaoImpl  {
    public PageModel<XcNews> queryXcNewsPage(XcNews news){
        Map<String,Object> map = new HashMap<String,Object>();
        StringBuilder hql = new StringBuilder();
        hql.append("select t from XcNews t where 1=1 ");
        if(news != null){
            if(news.getIsShow()!=null){
                hql.append(" and t.isShow =:isShow");
                map.put("isShow", +news.getIsShow());
            }
            if(StringUtils.isNotBlank(news.getTitle())){
                hql.append(" and t.title like :title ");
                map.put("title", "%"+news.getTitle()+"%");
            }

            if(StringUtils.isNotBlank(news.getStartTime())){
                hql.append("and t.createTime >= :startTime ");
                map.put("startTime", news.getStartTime());
            }

            if(StringUtils.isNotBlank(news.getEndTime())){
                hql.append(" and t.createTime <= :endTime ");
                map.put("endTime", news.getEndTime());
            }
        }
        hql.append(" order by t.id desc ");
        return this.queryForPageWithParams(hql.toString(),map,news.getCurrentPage(),news.getPageSize());
    }
   /* public PageModel<XcNews> queryXcNewsNext(Long id){
        Map<String,Object> map = new HashMap<String,Object>();
        StringBuilder hql = new StringBuilder();
        hql.append("select t from XcNews t where 1=1 and isShow=0");

        hql.append(" order by t.createTime desc ");
        return this.queryForPageWithParams(hql.toString(),map,news.getCurrentPage(),news.getPageSize());
    }
*/

}
