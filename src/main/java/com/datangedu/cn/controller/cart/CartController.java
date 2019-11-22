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

import com.datangedu.cn.dao.mapper.ProviderImgMapper;
import com.datangedu.cn.model.sysUser.ProviderImg;
import com.datangedu.cn.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Resource
	CartService cartService;
	ProviderImgMapper providerImgMapper;
	/*
	 * 展示
	 */
	@ResponseBody
	@RequestMapping(value = "/usercart",method =RequestMethod.GET)
	public Map<String,Object> userCart(HttpServletRequest request,String id){
		System.out.println("cart start");
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<Map<String,Object>> car=new ArrayList<Map<String,Object>>();
		
		// [{name: "店铺1",Provider:[{name"商品1"}，{name:"商品2"}]}，{name: "店铺2",Provider:[{name"商品1"}，{name:"商品2"}]}]
		
		// 循环所有商品
		// 如果是第一次i==0  直接向car add map1(已经处理好的){name: "店铺1",Provider:[{name"商品1"}]}
		// else {
			// 添加循环来确定car里面有没有当前商品所对应的店铺 num 来判断
			//循环car   
			//if(商品列表里的当前商品对应的店铺名字 == car 店铺名字){取Provider。add商品}
			//if else{判断num == 1}{continue;}
			// else{不等就car add map1(已经处理好的){name: "店铺2",Provider:[{name"商品1"}]}}
		//}
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
				System.out.println(i);
				car.add(map1);
			}
			
		}
		map.put("productlist",list1);
		map.put("car", car);
		return map;
		
	}
	/*
	if(car == null) {
		list.add((ProviderImg)list1);
	}else {
		for(int j = 0 ; j< list1.size(); j++) {
			if(list1.get(j).getProviderName() == list.get(i).getProviderName()) {
				j = 1;
				break;
			}
			if(providerName == list1.get(j).getProviderName()) {
    			list1.add((ProviderImg)list1);
    		}
			if(j == 1) {
				continue;
			}
			else {
				list.add((ProviderImg)list1);
			}
		}		
	}
}
/*
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

		/*
		 * 删除
		 */
			@ResponseBody
			@RequestMapping(value="/delcart",method=RequestMethod.GET)	
			public Map<String, Object> delCart(HttpServletRequest request,String serviceId){
				System.out.println("delCart start");
				Map<String, Object> map = new HashMap<String,Object>();
				int a = cartService.getDelCart(request, serviceId);
				map.put("code", 1);
				return map;
				
			}
			/*
			 *产品数量改变
			 */
			@ResponseBody
			@RequestMapping(value="/reducenum",method=RequestMethod.GET)	
			public Map<String, Object> reduceNum(HttpServletRequest request,String serviceId){
				System.out.println("reduceNum start");
				System.out.println("serviceId : " + serviceId);
				Map<String, Object> map = new HashMap<String,Object>();
				List<ProviderImg> list = cartService.getReduceNum(request,serviceId);
				ProviderImg providerImg = new ProviderImg();
				System.out.println("数量1： " +request.getParameter("orderNum"));
			    int num = Integer.parseInt(request.getParameter("orderNum"));
			    providerImg.setBuyNum(num);
			    providerImg.setServiceId(serviceId);
				int a = providerImgMapper.updateByNum(providerImg);
				System.out.println("影响行数：" + a);
				System.out.println("数量2： " + providerImg.getBuyNum());
				return map;
			}
			@ResponseBody
			@RequestMapping(value="/cartall",method=RequestMethod.GET)	
			public Map<String, Object> cartAll(HttpServletRequest request, String id){
				System.out.println("cartAll start");
				System.out.println(id);
				Map<String, Object> map = new HashMap<String,Object>();
				int all = cartService.getCartAll(request,id);
				map.put("all", all);
				return map;	
}
}