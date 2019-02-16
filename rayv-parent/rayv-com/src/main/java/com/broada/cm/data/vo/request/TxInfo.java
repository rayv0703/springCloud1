package com.broada.cm.data.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 交易通用信息
 */
public class TxInfo {
    /**
     * 交易跟踪号
     */
    @JsonProperty("tx_trace_id")
    private String txTraceId;
    /**
     * 交易码
     */
    @JsonProperty("tx_code")
    private String txCode;

    public String getTxTraceId() {
        return txTraceId;
    }

    public void setTxTraceId(String txTraceId) {
        this.txTraceId = txTraceId;
    }

    public String getTxCode() {
        return txCode;
    }

    public void setTxCode(String txCode) {
        this.txCode = txCode;
    }
}
