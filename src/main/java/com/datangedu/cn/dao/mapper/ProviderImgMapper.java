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

    int insert(ProviderImg record);

    int insertSelective(ProviderImg record);

    List<ProviderImg> selectByExampleWithBLOBs(ProviderImgExample example);

    List<ProviderImg> selectByExample(ProviderImgExample example);

    int updateByExampleSelective(@Param("record") ProviderImg record, @Param("example") ProviderImgExample example);

    int updateByExampleWithBLOBs(@Param("record") ProviderImg record, @Param("example") ProviderImgExample example);

    int updateByExample(@Param("record") ProviderImg record, @Param("example") ProviderImgExample example);
}