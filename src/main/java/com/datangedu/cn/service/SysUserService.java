package com.datangedu.cn.service;
import java.util.List;
import java.util.Map;
<<<<<<< HEAD

=======
>>>>>>> e73093061466a054fd7493cc24cb49c316a8effa

import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.model.sysUser.Administrator;
import com.datangedu.cn.model.sysUser.BuyUser;
import com.datangedu.cn.model.sysUser.OrderList;
import com.datangedu.cn.model.sysUser.ProviderImg;
import com.datangedu.cn.model.sysUser.SysUser;
public interface SysUserService {
	//public List<Administrator> getUserInfoById();
	public List<OrderList> getOrderUserInfoById();
	int setOrderUserInfoById();
	public Administrator setUserlogin(HttpServletRequest request);
	public void saveUserImg(BuyUser user) throws Exception;
	public int setUserRegion(HttpServletRequest request);
	public List<Administrator> findpassword(HttpServletRequest request);
	public BuyUser getUserInfo(String id);
<<<<<<< HEAD
	//找用户
	Administrator finUserByMap (Map<String,Object> map);
	int updateUserByMap(Map<String,Object> map);
=======
	Administrator finUserByMap(Map<String, Object> map);
	
>>>>>>> e73093061466a054fd7493cc24cb49c316a8effa

}
 