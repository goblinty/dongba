package com.ty.dongba.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ty.dongba.dao.TyLogDao;
import com.ty.dongba.entity.TyLog;
import com.ty.dongba.exception.ServiceException;
import com.ty.dongba.service.TyLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TyLogServiceImpl implements TyLogService {

    @Autowired
    private TyLogDao tyLogDao;


    @Override
    public PageInfo<TyLog> getPageLogs(String username, Integer pageCurrent) {

        //验证数据合法
        if (pageCurrent == null || pageCurrent<1) throw new ServiceException("页码不正确");

        //调用分页
        Integer pageSize = 4;

        PageHelper.startPage(pageCurrent,pageSize);
        List<TyLog> list = tyLogDao.findPageLogs(username);

        PageInfo<TyLog> page = new PageInfo<>(list);

        return page;
    }

    @Override
    public int deleteLogs(Integer... ids) {
        return 0;
    }
}
