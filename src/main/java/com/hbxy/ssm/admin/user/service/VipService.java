package com.hbxy.ssm.admin.user.service;

import com.hbxy.ssm.admin.user.model.Vip;
import com.hbxy.ssm.admin.user.model.VipExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VipService {
    long countByExample(VipExample example);

    int deleteByExample(VipExample example);

    int deleteByPrimaryKey(String vId);

    int insert(Vip record);

    int insertSelective(Vip record);

    List<Vip> selectByExample(VipExample example);

    Vip selectByPrimaryKey(String vId);

    int updateByExampleSelective(@Param("record") Vip record, @Param("example") VipExample example);

    int updateByExample(@Param("record") Vip record, @Param("example") VipExample example);

    int updateByPrimaryKeySelective(Vip record);

    int updateByPrimaryKey(Vip record);
}
