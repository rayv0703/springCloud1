package com.broada.cm.data.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 分页信息
 * pageNo和pageSize配合使用,并且相应报文会有对应的字段返回
 * offset和limit配合使用
 * pageNo和offset仅一个生效
 */
public class PaginationRequest {
    /**
     * 请求页码
     */
    @JsonProperty("current")
    private Integer pageNo;
    /**
     * 请求页面大小
     */
    @JsonProperty("pageSize")
    private Integer pageSize;
    /**
     * 偏移量
     */
    @JsonProperty("offset")
    private Integer offset;
    /**
     * 最大请求条数
     */
    @JsonProperty("limit")
    private Integer limit;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
