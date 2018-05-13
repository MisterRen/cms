package com.xinchuan.console.dao.page;

import com.xinchuan.console.common.BaseSqlDaoImpl;
import com.xinchuan.console.common.PageModel;
import com.xinchuan.console.model.XcTeamManage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiJiaLiang
 * @date 2018/5/12  17:23
 */
@Service
public class XcTeamManagePage extends BaseSqlDaoImpl {

    public PageModel<XcTeamManage> queryXcTeamManagePage(XcTeamManage xcTeamManage){
        Map<String,Object> map = new HashMap<String,Object>();
        StringBuilder hql = new StringBuilder();
        hql.append("select t from XcTeamManage t where 1=1 ");
        if(xcTeamManage != null){
            if(xcTeamManage.getIsShow()!=null){
                hql.append(" and t.isShow = :isShow ");
                map.put("isShow", xcTeamManage.getIsShow());
            }
            if(StringUtils.isNotBlank(xcTeamManage.getName())){
                hql.append(" and t.name like :name ");
                map.put("name", "%"+xcTeamManage.getName()+"%");
            }

            if(StringUtils.isNotBlank(xcTeamManage.getStartTime())){
                hql.append("and t.createTime >= :startTime ");
                map.put("startTime", xcTeamManage.getStartTime());
            }

            if(StringUtils.isNotBlank(xcTeamManage.getEndTime())){
                hql.append(" and t.createTime <= :endTime ");
                map.put("endTime", xcTeamManage.getEndTime());
            }
        }
        hql.append(" order by t.createTime desc ");
        return this.queryForPageWithParams(hql.toString(),map,xcTeamManage.getCurrentPage(),xcTeamManage.getPageSize());
    }
}
