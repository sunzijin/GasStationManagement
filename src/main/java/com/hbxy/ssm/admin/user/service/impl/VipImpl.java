package com.hbxy.ssm.admin.user.service.impl;

import com.hbxy.ssm.admin.user.mapper.VipMapper;
import com.hbxy.ssm.admin.user.model.Vip;
import com.hbxy.ssm.admin.user.model.VipExample;
import com.hbxy.ssm.admin.user.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VipImpl implements VipService {

    @Autowired
    VipMapper mapper;

    @Override
    public long countByExample(VipExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(VipExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String vId) {
        return mapper.deleteByPrimaryKey(vId);
    }

    @Override
    public int insert(Vip record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Vip record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Vip> selectByExample(VipExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Vip selectByPrimaryKey(String vId) {
        return mapper.selectByPrimaryKey(vId);
    }

    @Override
    public int updateByExampleSelective(Vip record, VipExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Vip record, VipExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Vip record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Vip record) {
        return mapper.updateByPrimaryKey(record);
    }
}
