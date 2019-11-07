package com.datangedu.cn.service;
import java.util.List;




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
	public List<Administrator> setUserlogin(HttpServletRequest request);
	public int Setusernumber(HttpServletRequest request);
	public void saveUserImg(BuyUser user) throws Exception;
	public int setUserRegion(HttpServletRequest request);
	public List<Administrator> findpassword(HttpServletRequest request);
	public BuyUser getUserInfo(String id);

}
 