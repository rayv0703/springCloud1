package com.broada.cm.data.vo.response;

import com.broada.cm.exception.entity.ErrorInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class TxResponseVo {
    /**
     * 交易状态
     * 00-成功
     * 01-失败
     */
    @JsonProperty("tx_status")
    private String txStatus;

    /**
     * 交易跟踪号
     */
    @JsonProperty("tx_trace_id")
    private String txTraceId;
    /**
     * 错误信息描述
     */
    @JsonProperty("error_info")
    private ErrorInfo errorInfo;
    /**
     * 分页信息公共域
     */
    @JsonProperty("pagination")
    private PaginationResponse pagination;
}
