package com.hbxy.ssm.admin.user.service.impl;

import com.hbxy.ssm.admin.user.mapper.GasMapper;
import com.hbxy.ssm.admin.user.model.Gas;
import com.hbxy.ssm.admin.user.model.GasExample;
import com.hbxy.ssm.admin.user.service.GasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GasImpl implements GasService {

    @Autowired
    GasMapper mapper;

    @Override
    public long countByExample(GasExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(GasExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String gId) {
        return mapper.deleteByPrimaryKey(gId);
    }

    @Override
    public int insert(Gas record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Gas record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Gas> selectByExample(GasExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Gas selectByPrimaryKey(String gId) {
        return mapper.selectByPrimaryKey(gId);
    }

    @Override
    public int updateByExampleSelective(Gas record, GasExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Gas record, GasExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Gas record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Gas record) {
        return mapper.updateByPrimaryKey(record);
    }
}
