package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.sysUser.Administrator;
import com.datangedu.cn.model.sysUser.AdministratorExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AdministratorMapper {
    long countByExample(AdministratorExample example);

    int deleteByExample(AdministratorExample example);

    int deleteByPrimaryKey(String id);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    List<Administrator> selectByExampleWithBLOBs(AdministratorExample example);


    Administrator selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByExampleWithBLOBs(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKeyWithBLOBs(Administrator record);

    int updateByPrimaryKey(Administrator record);

	List<Administrator> selectByExample(AdministratorExample administrator);

	static void updateByExample(Administrator administrator) {
		// TODO Auto-generated method stub
		
	}

}