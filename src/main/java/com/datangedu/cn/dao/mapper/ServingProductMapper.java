package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.sysUser.ServingProduct;
import com.datangedu.cn.model.sysUser.ServingProductExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ServingProductMapper {
    long countByExample(ServingProductExample example);

    int deleteByExample(ServingProductExample example);

    int deleteByPrimaryKey(String id);

    int insert(ServingProduct record);

    int insertSelective(ServingProduct record);

    List<ServingProduct> selectByExampleWithBLOBs(ServingProductExample example);

    List<ServingProduct> selectByExample(ServingProductExample example);

    ServingProduct selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ServingProduct record, @Param("example") ServingProductExample example);

    int updateByExampleWithBLOBs(@Param("record") ServingProduct record, @Param("example") ServingProductExample example);

    int updateByExample(@Param("record") ServingProduct record, @Param("example") ServingProductExample example);

    int updateByPrimaryKeySelective(ServingProduct record);

    int updateByPrimaryKeyWithBLOBs(ServingProduct record);

    int updateByPrimaryKey(ServingProduct record);
}