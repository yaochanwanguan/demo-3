package com.datangedu.cn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.sysUser.ProviderImg;

public interface CartService {

	public List<ProviderImg> getuserCart(String Id);

	public int getCartAdd(String spId, String id);

	public List<ProviderImg> getuserCartByName(String providerName, String id);

	public int getDelCart(HttpServletRequest request, String serviceId);

	public List<ProviderImg> getReduceNum(HttpServletRequest request, String serviceId);

	//数量改变
    int updateCart(int id ,int buy_num);




}
