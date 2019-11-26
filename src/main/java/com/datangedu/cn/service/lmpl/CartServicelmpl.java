package com.datangedu.cn.service.lmpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.dao.mapper.AdministratorMapper;
import com.datangedu.cn.model.sysUser.*;
import org.springframework.stereotype.Service;

import com.datangedu.cn.controller.id.Sequence;
import com.datangedu.cn.dao.mapper.ProviderImgMapper;
import com.datangedu.cn.dao.mapper.ServingProductMapper;
import com.datangedu.cn.service.CartService;
@Service
public class CartServicelmpl implements CartService{
@Resource
ProviderImgMapper providerImgMapper;
@Resource
ServingProductMapper servingProductMapper;
@Resource
AdministratorMapper administratorMapper;
////
//	购物车列表
////
	@Override
	public List<ProviderImg> getuserCart(String id) {
		/*System.out.println("Cart start");
		ProviderImgExample providerImgExample=new ProviderImgExample();
		ProviderImgExample.Criteria criteria=providerImgExample.createCriteria();
		criteria.andIdEqualTo(id);
		return providerImgMapper.selectByExample(providerImgMapper);*/
		return providerImgMapper.findUserCart(id);
	}
//	购物车添加商品
	@Override
	public int getCartAdd(String spId, String id) {
		System.out.println("getCartadd start");
		ServingProductExample servingProductExample=new ServingProductExample();
		ServingProductExample.Criteria criteria=servingProductExample.createCriteria();
		criteria.andIdEqualTo(id);
		Map where = new HashMap();
		where.put("id",spId);
		Administrator administrator = administratorMapper.finUserByMap(where);
		List<ServingProduct>list=servingProductMapper.selectByExample(servingProductExample);
		ProviderImg providerImg=new ProviderImg();
<<<<<<< HEAD
		providerImg.setService_id(id);
		//providerImg.setId(id);
		providerImg.setService_name(list.get(0).getServiceName());
		providerImg.setUnit_price(list.get(0).getUnitPrice());
		providerImg.setProvider_name(list.get(0).getProviderName());
		providerImg.setBuy_num(1);
		providerImg.setUser_id(spId);
		providerImg.setSum(1);
		providerImg.setUser_name(administrator.getUserName());
		providerImg.setProduct_picture(list.get(0).getProductPicture());
=======
		providerImg.setServiceId(Sequence.nextId());
		providerImg.setId(Sequence.nextId());
		providerImg.setServiceName(list.get(0).getServiceName());
		providerImg.setUnitPrice(list.get(0).getUnitPrice());
		providerImg.setProviderName(list.get(0).getProviderName());
		providerImg.setBuyNum(1);
>>>>>>> e73093061466a054fd7493cc24cb49c316a8effa
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
//购物车删除
@Override
public int getDelCart(HttpServletRequest request, String serviceId) {
<<<<<<< HEAD
	return providerImgMapper.deleteByExample(serviceId);
=======
	ProviderImgExample providerImgExample = new ProviderImgExample();
	ProviderImgExample.Criteria criteria = providerImgExample.createCriteria();
	criteria.andServiceIdEqualTo(serviceId);
	return providerImgMapper.deleteByExample(providerImgExample);
>>>>>>> e73093061466a054fd7493cc24cb49c316a8effa
}
/*
 *产品数量改变
 */
@Override
public List<ProviderImg> getReduceNum(HttpServletRequest request, String serviceId) {
	ProviderImgExample providerImgExample = new ProviderImgExample();
	ProviderImgExample.Criteria criteria = providerImgExample.createCriteria();
	criteria.andServiceIdEqualTo(serviceId);
	return providerImgMapper.selectByExample(providerImgMapper);
}
<<<<<<< HEAD


//修改购物车数量
	@Override
public int updateCart(int id ,int buy_num){
		providerImgMapper.updateCart(id,buy_num);
	return 1;
}

=======
@Override
public int getCartAll(HttpServletRequest request, String id) {
	ProviderImgExample providerImgExample = new ProviderImgExample();
	ProviderImgExample.Criteria criteria = providerImgExample.createCriteria();
	criteria.andIdEqualTo(id);
	return providerImgMapper.selectAll();
}
>>>>>>> e73093061466a054fd7493cc24cb49c316a8effa
}
