package com.datangedu.cn.service.lmpl;

import java.util.List;
import java.util.Map;
<<<<<<< HEAD

=======
>>>>>>> e73093061466a054fd7493cc24cb49c316a8effa

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.datangedu.cn.controller.id.Sequence;
import com.datangedu.cn.dao.mapper.AdministratorMapper;
import com.datangedu.cn.dao.mapper.BuyUserMapper;
import com.datangedu.cn.dao.mapper.OrderListMapper;
import com.datangedu.cn.dao.mapper.ProviderImgMapper;
import com.datangedu.cn.model.sysUser.*;
import com.datangedu.cn.service.SysUserService;
import org.springframework.stereotype.Service;

import com.datangedu.cn.util.MD5Util;

@Service

public class SysUserServicelmpl implements SysUserService {
<<<<<<< HEAD
    @Resource
    AdministratorMapper administratorMapper;
    @Resource
    OrderListMapper orderListMapper;
    @Resource
    ProviderImgMapper providerMapper;
    @Resource
    BuyUserMapper buyUserMapper;

    /*
     * @Override public List<Administrator> getUserInfoById(String id) { // TODO
     * Auto-generated method stub AdministratorExample administrator = new
     * AdministratorExample(); AdministratorExample.Criteria
     * criteria1=administrator.createCriteria(); criteria1.andIdEqualTo(id); return
     * AdministratorMapper.selectByExample(administrator); }
     */
    @Override
    public List<OrderList> getOrderUserInfoById() {
        OrderListExample order = new OrderListExample();
        OrderListExample.Criteria criteria = order.createCriteria();
        // criteria.andIdEqualTo("qwe");
        return orderListMapper.selectByExample(order);
    }

    @Override
    public int setOrderUserInfoById() {
        OrderList orderList = new OrderList();
        orderList.setId(1);
        return orderListMapper.insert(orderList);
    }

    //登陆
    @Override
=======
	@Resource
	AdministratorMapper administratorMapper;
	@Resource
	OrderListMapper orderListMapper;
	@Resource
	ProviderImgMapper providerMapper;
	@Resource
	BuyUserMapper buyUserMapper;

	/*
	 * @Override public List<Administrator> getUserInfoById(String id) { // TODO
	 * Auto-generated method stub AdministratorExample administrator = new
	 * AdministratorExample(); AdministratorExample.Criteria
	 * criteria1=administrator.createCriteria(); criteria1.andIdEqualTo(id); return
	 * AdministratorMapper.selectByExample(administrator); }
	 */
	@Override
	public List<OrderList> getOrderUserInfoById() {
		OrderListExample order = new OrderListExample();
		OrderListExample.Criteria criteria = order.createCriteria();
		// criteria.andIdEqualTo("qwe");
		return orderListMapper.selectByExample(order);
	}

	@Override
	public int setOrderUserInfoById() {
		OrderList orderList = new OrderList();
		orderList.setId("1");
		return orderListMapper.insert(orderList);
	}
//登陆
	@Override
>>>>>>> e73093061466a054fd7493cc24cb49c316a8effa
    public Administrator setUserlogin(HttpServletRequest request) {
        String cellphone = request.getParameter("cellphone");
        String password = MD5Util.getMD5(request.getParameter("password").getBytes());
        String inputCode = request.getParameter("inputCode");

        AdministratorExample administratorExample = new AdministratorExample();
        AdministratorExample.Criteria criteria = administratorExample.createCriteria();
        criteria.andCellphoneEqualTo(cellphone);
        criteria.andPasswordEqualTo(MD5Util.getMD5(request.getParameter("password").getBytes()));
<<<<<<< HEAD
        return administratorMapper.findUser(cellphone, password);
    }

    @Override
    public void saveUserImg(BuyUser user) throws Exception {
        int i = buyUserMapper.saveUserImg(user);
        if (i != 1) {
            throw new Exception("更新用户头像失败");
        }
    }

    public int setUserRegion(HttpServletRequest request) {
        String user_name = request.getParameter("user_name");
        String cellphone = request.getParameter("cellphone");
        String password = MD5Util.getMD5(request.getParameter("password").getBytes());
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String area = request.getParameter("area");
        System.out.println(user_name + "," + cellphone + "," + password + "," + province + "," + city + "," + area);
        Administrator administrator = new Administrator();
        administrator.setId(Sequence.nextId());
        administrator.setUserName(user_name);
        administrator.setCellphone(cellphone);
        administrator.setPassword(password);
        administrator.setProvince(province);
        administrator.setCity(city);
        administrator.setArea(area);
        return administratorMapper.insert(administrator);
    }

    @Override
    public List<Administrator> findpassword(HttpServletRequest request) {
        String cellphone = request.getParameter("cellphone");
        String password = MD5Util.getMD5(request.getParameter("password").getBytes());
        String inputCode = request.getParameter("inputCode");
        System.out.println(request.getParameter("cellphone"));
        System.out.println(request.getParameter("inputCode"));
        System.out.println(request.getParameter("password"));
        AdministratorExample administratorExample = new AdministratorExample();
        AdministratorExample.Criteria criteria = administratorExample.createCriteria();
        criteria.andCellphoneEqualTo(cellphone);
        return administratorMapper.selectByExample(administratorExample);
    }

    @Override
    public BuyUser getUserInfo(String id) {
        return buyUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public Administrator finUserByMap(Map<String,Object> map) {
        return administratorMapper.finUserByMap(map);
    }
    @Override
    public int updateUserByMap(Map<String,Object> map){
        return administratorMapper.updateUserByMap(map);
    }

//	@Override
//	public int findUser(String cellphone,String password){
//        tring password = MD5Util.getMD5(request.getParameter("password").getBytes());
//		return buyUserMapper.findUser(cellphone,password);
//	}
=======
        return buyUserMapper.findUser(cellphone, password);
    }
	@Override
	public void saveUserImg(BuyUser user) throws Exception {
		int i = buyUserMapper.saveUserImg(user);
		if (i != 1) {
			throw new Exception("更新用户头像失败");
		}
	}

	public int setUserRegion(HttpServletRequest request) {
		String user_name = request.getParameter("user_name");
		String cellphone = request.getParameter("cellphone");
		String password = MD5Util.getMD5(request.getParameter("password").getBytes());
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		System.out.println(user_name + "," + cellphone + "," + password + "," + province + "," + city + "," + area);
		Administrator administrator = new Administrator();
		administrator.setId(Sequence.nextId());
		administrator.setUserName(user_name);
		administrator.setCellphone(cellphone);
		administrator.setPassword(password);
		administrator.setProvince(province);
		administrator.setCity(city);
		administrator.setArea(area);
		return administratorMapper.insert(administrator);
	}

	@Override
	public List<Administrator> findpassword(HttpServletRequest request) {
		String cellphone = request.getParameter("cellphone");
		String password = MD5Util.getMD5(request.getParameter("password").getBytes());
		String inputCode = request.getParameter("inputCode");
		System.out.println(request.getParameter("cellphone"));
		System.out.println(request.getParameter("inputCode"));
		System.out.println(request.getParameter("password"));
		AdministratorExample administratorExample = new AdministratorExample();
		AdministratorExample.Criteria criteria = administratorExample.createCriteria();
		criteria.andCellphoneEqualTo(cellphone);
		return administratorMapper.selectByExample(administratorExample);
	}

	@Override
	public BuyUser getUserInfo(String id) {
		return buyUserMapper.selectByPrimaryKey(id);
	}
    @Override
    public Administrator finUserByMap(Map<String,Object> map) {
        return buyUserMapper.finUserByMap(map);
    }
>>>>>>> e73093061466a054fd7493cc24cb49c316a8effa

}
