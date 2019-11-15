package com.datangedu.cn.service;

import java.util.List;


import com.datangedu.cn.model.sysUser.ProviderImg;

public interface CartService {

	public List<ProviderImg> getuserCart(String Id);

	public int getCartAdd(String spId, String id);

	public List<ProviderImg> getuserCartByName(String providerName, String id);
	




}
