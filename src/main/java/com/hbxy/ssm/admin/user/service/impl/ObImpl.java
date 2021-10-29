package com.hbxy.ssm.admin.user.service.impl;

import com.hbxy.ssm.admin.user.mapper.ObMapper;
import com.hbxy.ssm.admin.user.mapper.VipMapper;
import com.hbxy.ssm.admin.user.model.Ob;
import com.hbxy.ssm.admin.user.model.ObExample;
import com.hbxy.ssm.admin.user.service.ObService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ObImpl implements ObService {

    @Autowired
    ObMapper mapper;

    @Override
    public long countByExample(ObExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ObExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String oId) {
        return mapper.deleteByPrimaryKey(oId);
    }

    @Override
    public int insert(Ob record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Ob record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Ob> selectByExample(ObExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Ob selectByPrimaryKey(String oId) {
        return mapper.selectByPrimaryKey(oId);
    }

    @Override
    public int updateByExampleSelective(Ob record, ObExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Ob record, ObExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Ob record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Ob record) {
        return mapper.updateByPrimaryKey(record);
    }
}
