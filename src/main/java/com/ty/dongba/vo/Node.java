package com.ty.dongba.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用于封装  Ztree
 */
@Data
@ToString
public class Node implements Serializable {
    private static final long serialVersionUID = 2818143982484872521L;

    private Integer id;
    private String name;
    private Integer parentId;

}
