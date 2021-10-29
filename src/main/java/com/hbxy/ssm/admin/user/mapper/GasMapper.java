package com.hbxy.ssm.admin.user.mapper;

import com.hbxy.ssm.admin.user.model.Gas;
import com.hbxy.ssm.admin.user.model.GasExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Mapper
public interface GasMapper {
    long countByExample(GasExample example);

    int deleteByExample(GasExample example);

    int deleteByPrimaryKey(String gId);

    int insert(Gas record);

    int insertSelective(Gas record);

    List<Gas> selectByExample(GasExample example);

    Gas selectByPrimaryKey(String gId);

    int updateByExampleSelective(@Param("record") Gas record, @Param("example") GasExample example);

    int updateByExample(@Param("record") Gas record, @Param("example") GasExample example);

    int updateByPrimaryKeySelective(Gas record);

    int updateByPrimaryKey(Gas record);
}