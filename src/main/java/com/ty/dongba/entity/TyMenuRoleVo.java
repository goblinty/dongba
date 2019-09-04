package com.ty.dongba.entity;

import lombok.Data;

import java.util.List;

@Data
public class TyMenuRoleVo {

    private Integer id;
    private String name;
    private String node;
    private List<Integer> menuId;
}
