package com.datangedu.cn.service.lmpl;

import com.datangedu.cn.dao.mapper.OrderListMapper;
import com.datangedu.cn.model.sysUser.OrderList;
import com.datangedu.cn.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderListService {
    @Autowired
    private OrderListMapper orderListMapper;

    @Override
    public void insert(OrderList order) {
        orderListMapper.insert(order);
    }

    @Override
    public void updateOrder(String orderNumber , int pay) {
        OrderList order = new OrderList();
        order.setOrderNumber(orderNumber);
        order.setPayType(pay);
        System.out.println(pay);
        orderListMapper.updateOrder(order);
    }

    @Override
    public List<OrderList> queryAll(String userName) {
      return orderListMapper.queryAll(userName);
    }
}