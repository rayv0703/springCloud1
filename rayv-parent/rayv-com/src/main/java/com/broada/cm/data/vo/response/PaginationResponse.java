package com.broada.cm.data.vo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaginationResponse {
    /**
     * 记录总数
     */
    @JsonProperty("total")
    private Long total;
    /**
     * 当前页码
     */
    @JsonProperty("current")
    private Integer currPage;
    /**
     * 当前数量
     */
    @JsonProperty("pageSize")
    private Integer pageSize;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


}
