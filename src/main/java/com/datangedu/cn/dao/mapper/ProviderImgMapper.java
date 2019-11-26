package com.datangedu.cn.dao.mapper;

import com.datangedu.cn.model.sysUser.ProviderImg;
import com.datangedu.cn.model.sysUser.ProviderImgExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ProviderImgMapper {
    long countByExample(ProviderImgExample example);

    int deleteByExample(String id);

    int insert(ProviderImg record);

    int insertSelective(ProviderImg record);

    List<ProviderImg> selectByExampleWithBLOBs(ProviderImgExample example);

    List<ProviderImg> selectByExample(ProviderImgMapper providerImgMapper);

    int updateByExampleSelective(@Param("record") ProviderImg record, @Param("example") ProviderImgExample example);

    int updateByExampleWithBLOBs(@Param("record") ProviderImg record, @Param("example") ProviderImgExample example);

    int updateByExample(@Param("record") ProviderImg record, @Param("example") ProviderImgExample example);

<<<<<<< HEAD
	void updateCart(int id,int buy_num);
	//购物车列表
    List<ProviderImg> findUserCart(String userId);
=======
	int updateByNum(ProviderImg record);

	int selectAll();
>>>>>>> e73093061466a054fd7493cc24cb49c316a8effa
}