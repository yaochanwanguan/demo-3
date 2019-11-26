package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.sysUser.Administrator;
import com.datangedu.cn.model.sysUser.BuyUser;
import com.datangedu.cn.model.sysUser.BuyUserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BuyUserMapper {
    long countByExample(BuyUserExample example);

    int deleteByExample(BuyUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(BuyUser record);

    int insertSelective(BuyUser record);

    List<BuyUser> selectByExampleWithBLOBs(BuyUserExample example);

    List<BuyUser> selectByExample(BuyUserExample example);

    BuyUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BuyUser record, @Param("example") BuyUserExample example);

    int updateByExampleWithBLOBs(@Param("record") BuyUser record, @Param("example") BuyUserExample example);

    int updateByExample(@Param("record") BuyUser record, @Param("example") BuyUserExample example);

    int updateByPrimaryKeySelective(BuyUser record);

    int updateByPrimaryKeyWithBLOBs(BuyUser record);

    int updateByPrimaryKey(BuyUser record);

	int saveUserImg(BuyUser user);

}