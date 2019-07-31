package com.ty.dongba.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TyDept implements Serializable {

    private static final long serialVersionUID = 6430730553587207965L;
    private Integer id;
    private String name;
    private Integer parentId;
    private Integer sort;
    private String note;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;
}
