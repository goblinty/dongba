package com.ty.dongba.vo;

import com.ty.dongba.entity.TyDept;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TyUserDeptVo implements Serializable {

    private static final long serialVersionUID = 4166337950773608579L;

    private Integer id;
    private String username;
    private String password;//md5
    private String salt;
    private String email;
    private String mobile;
    private Integer valid=1;
    private TyDept tyDept; //private Integer deptId;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;

}
