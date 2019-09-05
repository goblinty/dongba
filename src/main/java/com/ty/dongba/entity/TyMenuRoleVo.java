package com.ty.dongba.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TyMenuRoleVo implements Serializable {

    private static final long serialVersionUID = 7004818673841027993L;
    private Integer id;
    private String name;
    private String node;
    private List<Integer> menuId;
}
