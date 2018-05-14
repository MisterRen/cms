package com.xinchuan.console.dao.page;

import com.xinchuan.console.common.BaseSqlDaoImpl;
import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.model.XcProduct;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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
public class XcProductPage extends BaseSqlDaoImpl  {
    public PageModel<XcProduct> queryXcProductPage(XcProduct product){
        Map<String,Object> map = new HashMap<String,Object>();
        StringBuilder hql = new StringBuilder();
        hql.append("select t from XcProduct t where 1=1 ");
        if(product!=null){
            if(product.getIsShow()!=null){
                hql.append(" and t.isShow =:isShow");
                map.put("isShow", +product.getIsShow());
            }
            if(StringUtils.isNotBlank(product.getProdectName())){
                hql.append(" and t.prodectName like :name ");
                map.put("name", "%"+product.getProdectName()+"%");
            }

            if(StringUtils.isNotBlank(product.getStartTime())){
                hql.append("and t.createTime >= :startTime ");
                map.put("startTime", product.getStartTime());
            }

            if(StringUtils.isNotBlank(product.getEndTime())){
                hql.append(" and t.createTime <= :endTime ");
                map.put("endTime", product.getEndTime());
            }
        }
        hql.append(" order by t.level asc,t.createTime desc ");
        return this.queryForPageWithParams(hql.toString(),map,product.getCurrentPage(),product.getPageSize());
    }



}
