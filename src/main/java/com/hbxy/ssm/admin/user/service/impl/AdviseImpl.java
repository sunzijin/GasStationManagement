package com.hbxy.ssm.admin.user.service.impl;

import com.hbxy.ssm.admin.user.mapper.AdviseMapper;
import com.hbxy.ssm.admin.user.mapper.GasMapper;
import com.hbxy.ssm.admin.user.model.Advise;
import com.hbxy.ssm.admin.user.model.AdviseExample;
import com.hbxy.ssm.admin.user.service.AdviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdviseImpl implements AdviseService {

    @Autowired
    AdviseMapper mapper;

    @Override
    public long countByExample(AdviseExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AdviseExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String aId) {
        return mapper.deleteByPrimaryKey(aId);
    }

    @Override
    public int insert(Advise record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Advise record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Advise> selectByExample(AdviseExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Advise selectByPrimaryKey(String aId) {
        return mapper.selectByPrimaryKey(aId);
    }

    @Override
    public int updateByExampleSelective(Advise record, AdviseExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Advise record, AdviseExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Advise record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Advise record) {
        return mapper.updateByPrimaryKey(record);
    }
}
