package com.ty.dongba.service;

import com.github.pagehelper.PageInfo;
import com.ty.dongba.entity.TyLog;

public interface TyLogService {

    /**
     * 分页
     * @param username
     * @param pageCurrent
     * @return
     */
    PageInfo<TyLog> getPageLogs(String username,Integer pageCurrent);

    /**
     * 删除
     * @param ids
     * @return
     */
    int deleteLogs(Integer ...ids);

}
