package com.datangedu.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.sysUser.ServingProduct;


public interface ServingProductService {


	public List<ServingProduct> getServingProductList(HttpServletRequest request);
	
}
