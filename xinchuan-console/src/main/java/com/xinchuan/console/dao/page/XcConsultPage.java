package com.xinchuan.console.dao.page;

import com.xinchuan.console.common.BaseSqlDaoImpl;
import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.model.XcConsult;
import com.xinchuan.console.model.XcProduct;
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
public class XcConsultPage extends BaseSqlDaoImpl  {
    public PageModel<XcConsult> queryXcConsultPage(XcConsult consult){
        Map<String,Object> map = new HashMap<String,Object>();
        StringBuilder hql = new StringBuilder();
        hql.append("select t from XcConsult t where 1=1 ");
        if(consult != null){
            if(StringUtils.isNotBlank(consult.getUserName())){
                hql.append(" and t.userName like :name ");
                map.put("name", "%"+consult.getUserName()+"%");
            }

            if(StringUtils.isNotBlank(consult.getUserPhone())){
                hql.append("and t.userPhone like :userPhone ");
                map.put("userPhone", "%"+consult.getUserPhone()+"%");
            }

            if(StringUtils.isNotBlank(consult.getUserEmail())){
                hql.append(" and t.userEmail like :userEmail ");
                map.put("userEmail", "%"+consult.getUserEmail()+"%");
            }
        }
        hql.append(" order by t.createTime desc ");
        return this.queryForPageWithParams(hql.toString(),map,consult.getCurrentPage(),consult.getPageSize());
    }


}
