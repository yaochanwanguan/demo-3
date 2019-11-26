package com.datangedu.cn.controller.order;

import com.datangedu.cn.model.sysUser.Administrator;
import com.datangedu.cn.model.sysUser.OrderList;
import com.datangedu.cn.model.sysUser.OrderVo;
import com.datangedu.cn.model.sysUser.ProviderImg;
import com.datangedu.cn.service.CartService;
import com.datangedu.cn.service.OrderListService;
import com.datangedu.cn.service.SysUserService;
import com.datangedu.cn.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/OrderController")
public class OrderController {
    @Autowired
    private CartService cartService;

    @Autowired
    private OrderListService orderListService;

    @Autowired
    private SysUserService sysUserService;

    //创建订单
    @RequestMapping("/createOrder")
    @ResponseBody
    public OrderVo createOrder(HttpServletRequest request){
        String userId = UserUtil.getUserId(request); //获得用户
        System.out.println(userId);
        //创建订单
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String orderNumber = "S";
        orderNumber+= sdf.format(new Date()) + (int)(Math.random()*900)+100;
        //获得用户该用户购物车所有商品
        List<ProviderImg> list = cartService.getuserCart(userId);
        Random random = new Random();

        //创建时间
        String createTime = sdf1.format(new Date());

        //订单明细
        String pNum = list.size()+"";

        //订单总额
        Double money = 0.0;
        for (int i = 0; i < list.size(); i++){
            OrderList order = new OrderList();
            int id = (int)Math.floor((random.nextDouble()*100000.0)) + 1;;
            order.setId(id);
            order.setOrderNumber(orderNumber);
            order.setOrderContent(list.get(i).getService_name());
            order.setOrderMount(list.get(i).getSum()+0.0);
            order.setUserBuy(list.get(i).getUser_name());
            order.setStatus(1);
            order.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            order.setBuySum(list.get(i).getBuy_num());
            order.setImg(list.get(i).getProduct_picture());
            //加入到订单中
            orderListService.insert(order);
            money+=order.getOrderMount();
        }
        OrderVo vo = new OrderVo();
        vo.setOrderNumber(orderNumber);
        vo.setMoney(money);
        vo.setCreateTime(createTime);
        vo.setpNum(pNum);
        return vo;
    }

    //修改订单状态 为已支付 和支付方式
    @ResponseBody
    @RequestMapping("/updateOrder")
    public String updateOrder(String orderNumber,int pay){
        orderListService.updateOrder(orderNumber,pay);
        return "成功";
    }

    //获得所有订单
    @ResponseBody
    @RequestMapping("/queryAll")
    public Map queryAll(HttpServletRequest request){
        String userId = UserUtil.getUserId(request);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",userId);
        Administrator administrator = sysUserService.finUserByMap(map);
        System.out.println(administrator.toString());
        Map result  = new HashMap();
        result.put("user",administrator);
        result.put("orderList",orderListService.queryAll(administrator.getUserName()));
       return result;
    }
}
