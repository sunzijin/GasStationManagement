package com.hbxy.ssm.admin.user.mapper;

import com.hbxy.ssm.admin.user.model.Vip;
import com.hbxy.ssm.admin.user.model.VipExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface VipMapper {
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