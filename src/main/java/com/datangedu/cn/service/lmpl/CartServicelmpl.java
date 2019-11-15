package com.datangedu.cn.service.lmpl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datangedu.cn.dao.mapper.ProviderImgMapper;
import com.datangedu.cn.dao.mapper.ServingProductMapper;
import com.datangedu.cn.model.sysUser.ProviderImg;
import com.datangedu.cn.model.sysUser.ProviderImgExample;
import com.datangedu.cn.model.sysUser.ServingProduct;
import com.datangedu.cn.model.sysUser.ServingProductExample;
import com.datangedu.cn.service.CartService;
@Service
public class CartServicelmpl implements CartService{
@Resource
ProviderImgMapper providerImgMapper;
@Resource
ServingProductMapper servingProductMapper;
////
//	购物车列表
////
	@Override
	public List<ProviderImg> getuserCart(String id) {
		System.out.println("Cart start");
		ProviderImgExample providerImgExample=new ProviderImgExample();
		ProviderImgExample.Criteria criteria=providerImgExample.createCriteria();
		criteria.andIdEqualTo(id);
		return providerImgMapper.selectByExample(null);
	}
//	购物车添加商品
	@Override
	public int getCartAdd(String spId, String id) {
		System.out.println("getCartadd start");
		ServingProductExample servingProductExample=new ServingProductExample();
		ServingProductExample.Criteria criteria=servingProductExample.createCriteria();
		criteria.andIdEqualTo(id);
		List<ServingProduct>list=servingProductMapper.selectByExample(servingProductExample);
		ProviderImg providerImg=new ProviderImg();
		providerImg.setServiceId(list.get(0).getId());
		providerImg.setId(id);
		providerImg.setServiceName(list.get(0).getServiceName());
		providerImg.setUnitPrice(list.get(0).getUnitPrice());
		providerImg.setProviderName(list.get(0).getProviderName());
		return providerImgMapper.insert(providerImg);
	}

	
@Override
public List<ProviderImg> getuserCartByName(String providerName, String id) {
ProviderImgExample providerImgExample=new ProviderImgExample();
ProviderImgExample.Criteria criteria=providerImgExample.createCriteria();
criteria.andProviderNameEqualTo(providerName);
criteria.andIdEqualTo(id);
return providerImgMapper.selectByExample(null);
}

}
