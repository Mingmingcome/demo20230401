package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @who luhaoming
 * @when 2020/7/27 17:37
 * @what 基础model
 */
@Getter
@Setter
public class BaseModel implements Serializable {

    private static final long serialVersionUID = -1812877601959684400L;
    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 最后更新人
     */
    private String lastUpdatedBy;

    /**
     * 最后更新时间
     */
    private Date lastUpdatedDate;
}
