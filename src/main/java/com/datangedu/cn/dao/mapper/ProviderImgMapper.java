package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.sysUser.ProviderImg;
import com.datangedu.cn.model.sysUser.ProviderImgExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ProviderImgMapper {
    long countByExample(ProviderImgExample example);

    int deleteByExample(ProviderImgExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProviderImg record);

    int insertSelective(ProviderImg record);

    List<ProviderImg> selectByExample(ProviderImgExample example);

    ProviderImg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProviderImg record, @Param("example") ProviderImgExample example);

    int updateByExample(@Param("record") ProviderImg record, @Param("example") ProviderImgExample example);

    int updateByPrimaryKeySelective(ProviderImg record);

    int updateByPrimaryKey(ProviderImg record);
}