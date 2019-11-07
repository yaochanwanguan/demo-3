package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.sysUser.ServiceUser;
import com.datangedu.cn.model.sysUser.ServiceUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ServiceUserMapper {
    long countByExample(ServiceUserExample example);

    int deleteByExample(ServiceUserExample example);

    int deleteByPrimaryKey(String providerId);

    int insert(ServiceUser record);

    int insertSelective(ServiceUser record);

    List<ServiceUser> selectByExample(ServiceUserExample example);

    ServiceUser selectByPrimaryKey(String providerId);

    int updateByExampleSelective(@Param("record") ServiceUser record, @Param("example") ServiceUserExample example);

    int updateByExample(@Param("record") ServiceUser record, @Param("example") ServiceUserExample example);

    int updateByPrimaryKeySelective(ServiceUser record);

    int updateByPrimaryKey(ServiceUser record);
}