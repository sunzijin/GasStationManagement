package com.hbxy.ssm.admin.user.service;

import com.hbxy.ssm.admin.user.model.Sales;
import com.hbxy.ssm.admin.user.model.SalesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalesService {
    long countByExample(SalesExample example);

    int deleteByExample(SalesExample example);

    int deleteByPrimaryKey(String sId);

    int insert(Sales record);

    int insertSelective(Sales record);

    List<Sales> selectByExample(SalesExample example);

    Sales selectByPrimaryKey(String sId);

    int updateByExampleSelective(@Param("record") Sales record, @Param("example") SalesExample example);

    int updateByExample(@Param("record") Sales record, @Param("example") SalesExample example);

    int updateByPrimaryKeySelective(Sales record);

    int updateByPrimaryKey(Sales record);
}
