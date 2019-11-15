package com.datangedu.cn.service.lmpl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.ServingProductMapper;
import com.datangedu.cn.model.sysUser.ServingProduct;
import com.datangedu.cn.model.sysUser.ServingProductExample;
import com.datangedu.cn.service.ServingProductService;

@Service
public class ServingProductServiceImpl implements ServingProductService{
	@Resource
	ServingProductMapper servingProductMapper;

	@Override
	public List<ServingProduct> getServingProductList(HttpServletRequest request) {
		ServingProductExample servingProductExample = new ServingProductExample();
		ServingProductExample.Criteria criteria=servingProductExample.createCriteria();
		return servingProductMapper.selectByExample(servingProductExample);
}
	

}
