package com.datangedu.cn.controller.ServingProduct;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datangedu.cn.model.sysUser.ServingProduct;
import com.datangedu.cn.service.ServingProductService;

@Controller
@RequestMapping("/ServingProduct")
public class ServingProductController {
	@Resource
	ServingProductService servingProductService;
	
	@ResponseBody
	@RequestMapping(value = "/ServingProductlist",method = RequestMethod.GET)
	public Map<String,Object> ServingProductList(HttpServletRequest request){
		System.out.println("providerProdutList start");
		//HttpSession session =  request.getSession();
		Map<String,Object> map = new HashMap<String,Object>();
		List<ServingProduct> ServingProductList = servingProductService.getServingProductList(request);
		map.put("ServingProductList", ServingProductList);
		return map;
	}
}
