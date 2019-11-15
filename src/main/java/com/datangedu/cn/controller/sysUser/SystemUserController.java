
package com.datangedu.cn.controller.sysUser;

import java.io.ByteArrayOutputStream;



import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.datangedu.cn.dao.mapper.AdministratorMapper;
import com.datangedu.cn.model.sysUser.Administrator;
import com.datangedu.cn.model.sysUser.BuyUser;
import com.datangedu.cn.model.sysUser.OrderList;
import com.datangedu.cn.model.sysUser.ProviderImg;
import com.datangedu.cn.model.sysUser.SysUser;
import com.datangedu.cn.service.SysUserService;




@Controller
@RequestMapping("/sysuser")
public class SystemUserController {

	
		/*@Resource 
		SysUserService sysUserService;
		@RequestMapping("/sysuserlist" )
		public String getUserInfoById(Map<String,Object> map) {
			List<Administrator> Administratorlist = sysUserService. getUserInfoById("0001");
			map.put("Administratorlist", Administratorlist);
			return"userlist";
		}*/
		@Resource 
		SysUserService sysUserService;
		/*@RequestMapping("/orderlist" )
		public String getUserInfoById(String id,Map<String,Object> map) {
			List<OrderList>  orderInfo = sysUserService. getOrderUserInfoById(id);
			map.put(" orderInfo",  orderInfo);
			return "orderInfo";
		}*/
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/orderlist",method =RequestMethod.POST) public
	 * Map<String,Object>getUserListById(HttpServletRequest request) { //String id =
	 * request.getParameter("id"); Map<String,Object> map = new
	 * HashMap<String,Object>(); int orderInfo = sysUserService.
	 * setOrderUserInfoById(); map.put("orderInfo", orderInfo); return map; }
	 */
		/*
		 * 登陆
		 */
		@ResponseBody
		@RequestMapping(value = "/userlogin",method =RequestMethod.POST)
		public Map<String,Object>setUserlogin(HttpServletRequest request){
			HttpSession session=request.getSession();
			Map<String,Object> map = new HashMap<String,Object>();
			List<Administrator>list=sysUserService.setUserlogin(request);
		
			if(request.getParameter("cellphone").length()==0) {
				map.put("adm", "手机号不能为空");
			}else if(request.getParameter("password").length()==0) {
				map.put("adm", "密码不能为空");
			}else if(list == null) {
				map.put("adm", "请输入正确的手机号或密码");
			}else if(request.getParameter("inputCode").length()==0) {
				map.put("adm", "验证码不能为空");
			}else if(!request.getParameter("inputCode").equalsIgnoreCase((String) session.getAttribute("code"))) {
				map.put("adm", "请输入正确的验证码 ");
			}else {
				
				map.put("adm", "登陆成功");
			}
			
			return map;
		}
		/*
		 * 注册
		 */
		@ResponseBody
		@RequestMapping(value="/userregister",method=RequestMethod.POST)
		public Map<String,Object> userregister(HttpServletRequest request){
			System.out.println("setUserRegion start");
			HttpSession session=request.getSession();
			Map<String,Object> map = new HashMap<String,Object>();
			int Administrator=sysUserService.setUserRegion(request);
			if(request.getParameter("user_name").length()==0) {
				map.put("adm","姓名不能为空");
			}
			else if(request.getParameter("cellphone").length()==0) {
				map.put("adm","手机号不能为空");
			}else if(request.getParameter("password").length()==0) {
				map.put("adm","密码不能为空");
			}else if(request.getParameter("inputCode").length()==0) {
				map.put("adm","验证码不能为空");
			}else if(!request.getParameter("inputCode").equalsIgnoreCase((String) session.getAttribute("code"))){
				map.put("adm","请输入正确的验证码");
			}else if(request.getParameter("province").length()==0) {
				map.put("adm","省不能为空");
			}else if(request.getParameter("city").length()==0) {
				map.put("adm","城市不能为空");
			}else if(request.getParameter("area").length()==0) {
				map.put("adm","区不能为空");
			}else {
				map.put("adm","注册成功");
			}
			return map;
		}
		@ResponseBody
		@RequestMapping(value="/userfind",method=RequestMethod.POST)
		public Map<String,Object> findpassword(HttpServletRequest request){
			System.out.println("findpassword start");
			HttpSession session=request.getSession();
			Map<String,Object> map = new HashMap<String,Object>();
			List<Administrator>Administrator=sysUserService.findpassword(request);
			 if(request.getParameter("cellphone").length()==0) {
				map.put("adm","手机号不能为空");
			}else if(request.getParameter("password").length()==0) {
				map.put("adm","密码不能为空");
			}else if(request.getParameter("inputCode").length()==0) {
				map.put("adm","验证码不能为空");
			}else if(!request.getParameter("inputCode").equalsIgnoreCase((String) session.getAttribute("code"))){
				map.put("adm","请输入正确的验证码");
			}else if(request.getParameter("querenpassword").length()==0) {
				map.put("adm","确认密码不能为空");
			}else {
				if(Administrator==null){
					map.put("adm","请输入正确的手机号");
				}else {
					Administrator administrator=new Administrator();
					administrator.setPassword(request.getParameter("password"));
					administrator.setCellphone(request.getParameter("cellphone"));
					AdministratorMapper.updateByExample(administrator);
					map.put("adm","修改密码成功");
				}
			}
			return map;
		}
		
		@RequestMapping("/saveUserImg")
		public String saveUserImg(MultipartFile file,String id) {
			Map<Object,Object> result = new HashMap<Object,Object>();
			System.out.println(file+id);
			try {
			// 获取客户端传图图片的输入流
			InputStream ins = file.getInputStream();
			byte[] buffer=new byte[1024];//bit---byte---1k---1msssssss
			int len=0;
			 // 字节输出流
			 ByteArrayOutputStream bos=new ByteArrayOutputStream();
			while((len=ins.read(buffer))!=-1){
				bos.write(buffer,0,len);
			 }
			 bos.flush();
			byte data[] = bos.toByteArray();
			System.out.println(data);
			// 调用接口对图片进行存储
			BuyUser user = new BuyUser();
			 user.setId(id);
			user.setHeadImg(data);		
			sysUserService.saveUserImg(user);	            
			result.put("code",1);
				result.put("msg", "保存头像成功");
			} catch (Exception e) {
				result.put("code",0);
				result.put("msg", "保存头像失败");
				return "uploaderror";
			 }				
			return "e-commerce_account.html";	
		}
		@RequestMapping(value = "/headImg", produces = MediaType.IMAGE_PNG_VALUE)
		public ResponseEntity<byte[]> headImg( String id) throws Exception{

			byte[] imageContent ;
			// 根据id获取当前用户的信息
			BuyUser user = sysUserService.getUserInfo(id);
					        
			imageContent = user.getHeadImg();
			System.out.println("图片==="+user.getHeadImg());
					        
			// 设置http头部信息
			final HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_PNG);
			// 返回响应实体
			return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
		}


}

		



