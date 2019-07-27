package com.ty.dongba.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TyMenu implements Serializable {

    private static final long serialVersionUID = -7618705311693389215L;
    private Integer id;
    private String name;
    private String url;
    private Integer type;
    private Integer sort;
    private String note;
    private Integer parentId;
    private String permission;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;
}
