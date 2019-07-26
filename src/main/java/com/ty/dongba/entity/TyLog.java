package com.ty.dongba.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 映射 ty_logs
 */

@Data
//连接式
@Accessors(chain = true)
@ToString
public class TyLog implements Serializable {

    private static final long serialVersionUID = -4289307458243454802L;

    private Integer id;
    private String username;
    private String operation;
    private String method;
    private String params;
    private Long time;
    private String ip;
    private Date createdTime;
}
