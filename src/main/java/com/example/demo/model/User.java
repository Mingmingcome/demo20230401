package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @who luhaoming
 * @when 2020/7/27 17:37
 * @what 用户模型类
 */
@Getter
@Setter
public class User extends BaseModel {
    private String userId;
    private String name;
    private String orgCode;
    private String orgName;
    private String status;
    private String userType;
}
