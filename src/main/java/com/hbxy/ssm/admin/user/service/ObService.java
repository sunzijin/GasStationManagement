package com.hbxy.ssm.admin.user.service;

import com.hbxy.ssm.admin.user.model.Ob;
import com.hbxy.ssm.admin.user.model.ObExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ObService {
    long countByExample(ObExample example);

    int deleteByExample(ObExample example);

    int deleteByPrimaryKey(String oId);

    int insert(Ob record);

    int insertSelective(Ob record);

    List<Ob> selectByExample(ObExample example);

    Ob selectByPrimaryKey(String oId);

    int updateByExampleSelective(@Param("record") Ob record, @Param("example") ObExample example);

    int updateByExample(@Param("record") Ob record, @Param("example") ObExample example);

    int updateByPrimaryKeySelective(Ob record);

    int updateByPrimaryKey(Ob record);
}
