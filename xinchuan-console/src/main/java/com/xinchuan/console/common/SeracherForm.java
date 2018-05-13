package com.xinchuan.console.common;

import java.util.HashMap;
import java.util.Map;

public class SeracherForm {
    private String startTime;
    private String endTime;
    private Integer currentPage=1;
    private Integer pageSize=10;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 查询条件
     */
/*    private Map<String, String> condition = new HashMap<String, String>();

    public void addParam(String name, String value) {
        condition.put(name, value);
    }

    public void addParams(Map<String, String> map) {
        condition.putAll(map);
    }

    public void removeParam(String key) {
        condition.remove(key);
    }

    public Map<String, String> getCondition() {
        return condition;
    }

    public void setCondition(Map<String, String> condition) {
        this.condition = condition;
    }*/

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
