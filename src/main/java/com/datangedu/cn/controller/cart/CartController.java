package com.datangedu.cn.controller.cart;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.sysUser.Administrator;
import com.datangedu.cn.service.SysUserService;
import com.datangedu.cn.util.UserUtil;
import org.springframework.web.bind.annotation.*;

import com.datangedu.cn.dao.mapper.ProviderImgMapper;
import com.datangedu.cn.model.sysUser.ProviderImg;
import com.datangedu.cn.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    CartService cartService;
    ProviderImgMapper providerImgMapper;
    @Resource
    SysUserService sysUserService;
    /*
     * 展示
     */
    @ResponseBody
    @RequestMapping(value = "/usercart", method = RequestMethod.GET)
    public Map<String, Object> userCart(HttpServletRequest request, String userId) {
        Map<String, Object> map = new HashMap<String, Object>();
        String id = request.getParameter("id");
        Administrator user = sysUserService.finUserByMap(new HashMap(){{put("id",id);}});
        List<ProviderImg> cart = cartService.getuserCart(id);
        System.out.println(cart);
        if (cart != null) {
            BigDecimal totalPrice = new BigDecimal("0");//总金额
            int cartNum = 0;//总数
            for (ProviderImg providerImg : cart) {
//                System.out.println("shuliang == "+providerImg.getBuy_num());
//                System.out.println("jiage=="+providerImg.getSum()+"="+providerImg.getUser_id()+"="+providerImg.getService_id());
                totalPrice = totalPrice.add(new BigDecimal(providerImg.getSum()));
                cartNum += providerImg.getBuy_num();
            }
            map.put("totalPrice",totalPrice);
            map.put("cartNum",cartNum);
            map.put("cartList", cart);
            map.put("user",user);
        } else {
            map.put("cartList", null);
        }
        return map;


		/*System.out.println("cart start");
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
				car.add(map1);
			}

		}
		map.put("productlist",list1);
		map.put("car", car);
		System.out.println(map.toString());
		return map;*/

    }

    /*
     * 购物车添加
     */
    @ResponseBody
    @RequestMapping(value = "/cartadd", method = RequestMethod.GET)
    public Map<String, Object> cartAdd(HttpServletRequest request, String id, String serviceId) {
        System.out.println("cartAdd start");
        System.out.println("商品ID：" + serviceId);
        System.out.println("客户ID：" + id);
        Map<String, Object> map = new HashMap<String, Object>();
        cartService.getCartAdd(id, serviceId);
        return map;
    }

    /*
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/delcart", method = RequestMethod.GET)
    public Map<String, Object> delCart(HttpServletRequest request, String serviceId) {
        System.out.println("delCart start");
        Map<String, Object> map = new HashMap<String, Object>();
        int a = cartService.getDelCart(request, serviceId);
        map.put("code", 1);
        return map;

    }

    /*
     *产品数量改变
     */
    @ResponseBody
    @RequestMapping(value = "/reducenum", method = RequestMethod.GET)
    public Map<String, Object> reduceNum(HttpServletRequest request, String serviceId) {
        String status = request.getParameter("status");
        String id = request.getParameter("id");
        String by_num = request.getParameter("by_num");
        System.out.println(status);
        cartService.updateCart(Integer.parseInt(id),Integer.parseInt(by_num));




 /*       System.out.println("reduceNum start");
        System.out.println("serviceId : " + serviceId);
        Map<String, Object> map = new HashMap<String, Object>();
        List<ProviderImg> list = cartService.getReduceNum(request, serviceId);
        ProviderImg providerImg = new ProviderImg();
        System.out.println("数量1： " + request.getParameter("orderNum"));
        int num = Integer.parseInt(request.getParameter("orderNum"));
//        providerImg.setBuyNum(num);
//        providerImg.setServiceId(serviceId);
//        int a = providerImgMapper.updateByNum(providerImg);
//        System.out.println("影响行数：" + a);
//        System.out.println("数量2： " + providerImg.getBuyNum());*/
        return null;
    }


}
