package com.bytedance.douyinclouddemo.model;

import lombok.Data;

@Data
public class SetNameRequest {
    private String target;
    private String name;
}
