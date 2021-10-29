package com.hbxy.ssm.admin.user.service.impl;

import com.hbxy.ssm.admin.user.mapper.SalesMapper;
import com.hbxy.ssm.admin.user.mapper.VipMapper;
import com.hbxy.ssm.admin.user.model.Sales;
import com.hbxy.ssm.admin.user.model.SalesExample;
import com.hbxy.ssm.admin.user.service.SalesService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesImpl implements SalesService {

    @Autowired
    SalesMapper mapper;


    @Override
    public long countByExample(SalesExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SalesExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String sId) {
        return mapper.deleteByPrimaryKey(sId);
    }

    @Override
    public int insert(Sales record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Sales record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Sales> selectByExample(SalesExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Sales selectByPrimaryKey(String sId) {
        return mapper.selectByPrimaryKey(sId);
    }

    @Override
    public int updateByExampleSelective(Sales record, SalesExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Sales record, SalesExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Sales record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Sales record) {
        return mapper.updateByPrimaryKey(record);
    }
}
