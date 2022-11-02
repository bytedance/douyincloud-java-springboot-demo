package com.bytedance.douyinclouddemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class JsonResponse {
    @JsonFormat
    private Integer errNo;
    private String errMsg;
    private String data;

    public void success(String data) {
        this.errMsg = "success";
        this.errNo = 0;
        this.data = data;
    }

    public void failure(String errMsg) {
        this.errMsg = errMsg;
        this.errNo = -1;
    }
}
