package com.hbxy.ssm.admin.user.service;

import com.hbxy.ssm.admin.user.model.Advise;
import com.hbxy.ssm.admin.user.model.AdviseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdviseService {
    long countByExample(AdviseExample example);

    int deleteByExample(AdviseExample example);

    int deleteByPrimaryKey(String aId);

    int insert(Advise record);

    int insertSelective(Advise record);

    List<Advise> selectByExample(AdviseExample example);

    Advise selectByPrimaryKey(String aId);

    int updateByExampleSelective(@Param("record") Advise record, @Param("example") AdviseExample example);

    int updateByExample(@Param("record") Advise record, @Param("example") AdviseExample example);

    int updateByPrimaryKeySelective(Advise record);

    int updateByPrimaryKey(Advise record);
}
