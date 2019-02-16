package com.broada.cm.data.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 请求报文基类
 */
public abstract class TxRequestVo {
    /**
     * 交易信息公共域
     */
    @JsonProperty("tx_info")
    private TxInfo txInfo;

    /**
     * 分页信息公共域
     */
    @JsonProperty("pagination")
    private PaginationRequest pagination;

    public TxInfo getTxInfo() {
        return txInfo;
    }

    public void setTxInfo(TxInfo txInfo) {
        this.txInfo = txInfo;
    }

    public PaginationRequest getPagination() {
        return pagination;
    }

    public void setPagination(PaginationRequest pagination) {
        this.pagination = pagination;
    }
}
