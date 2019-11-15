package com.datangedu.cn.controller.cart;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datangedu.cn.model.sysUser.ProviderImg;
import com.datangedu.cn.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Resource
	CartService cartService;
	/*
	 * 展示
	 */
	@ResponseBody
	@RequestMapping(value = "/usercart",method =RequestMethod.GET)
	public Map<String,Object> userCart(HttpServletRequest request,String id){
		System.out.println("cart start");
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> car=new ArrayList<Map<String,Object>>();
		List<ProviderImg>list=cartService.getuserCart(id);
		List<ProviderImg>list1=null;
		for(int i=0;i<list.size();i++) {
			String providerName=list.get(i).getProviderName();
			String provideId=list.get(i).getProviderId();
			Map<String,Object> map1 = new HashMap<String,Object>();
			int num=0;
			for(Map<String,Object>name:car) {
				if(name.get("name").equals(providerName)) {
					num=1;
					break;
				}
			}
			if(num==1) {
				continue;
			}else {
				list1=cartService.getuserCartByName(providerName,id);
				map1.put("name", providerName);
				map1.put("productlist", list1);
				car.add(map1);
			}
		}
		map.put("productlist",list1);
		map.put("car", car);
		return map;
	}
	/*
	 * 购物车添加
	 */
		@ResponseBody
		@RequestMapping(value = "/cartadd",method =RequestMethod.GET)
		public Map<String,Object> cartAdd(HttpServletRequest request, String id, String serviceId){
			System.out.println("cartAdd start");
			System.out.println("商品ID："+serviceId);
			System.out.println("客户ID："+id);
			Map<String,Object> map = new HashMap<String,Object>();
			cartService.getCartAdd(id,serviceId);
			return map;
		}
	}


