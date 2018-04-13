package com.chinac.hermes.webhost.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.slf4j.MDC;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ReturnData", description = "ReturnData desc")
public class ReturnData<ReturnData> implements Serializable {

    private static final long serialVersionUID = -8268855831539863250L;
    @ApiModelProperty(notes = "请求编号", value = "requestId")
    private String requestId;

    @JsonInclude(Include.NON_NULL)
    @ApiModelProperty(notes = "返回值", value = "data")
    private ReturnData data;

    @JsonInclude(Include.NON_NULL)
    @ApiModelProperty(notes = "返回状态码", value = "errorCode")
    private String errorCode;

    @JsonInclude(Include.NON_NULL)
    @ApiModelProperty(notes = "返回错误详细", value = "errorMessage")
    private String errorMessage;

    @JsonIgnore
    @ApiModelProperty(notes = "返回httpCode", value = "httpCode")
    private Integer httpCode;

    public ReturnData(String errorCode, String errorMessage, Integer httpCode) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.httpCode = httpCode;
        this.requestId = MDC.get(CommonConstants.REQUEST_ID_KEY);
    }

    public ReturnData(ReturnData data) {
        super();
        this.data = data;
        this.requestId = MDC.get(CommonConstants.REQUEST_ID_KEY);
    }

    public ReturnData() {
        super();
        this.requestId = MDC.get(CommonConstants.REQUEST_ID_KEY);
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public ReturnData getData() {
        return data;
    }

    public void setData(ReturnData data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }
}
