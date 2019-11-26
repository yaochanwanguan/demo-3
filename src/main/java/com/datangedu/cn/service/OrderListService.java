package com.datangedu.cn.service;

import com.datangedu.cn.model.sysUser.OrderList;

import java.util.List;

public interface OrderListService {
    public void insert(OrderList order);

    void updateOrder(String orderNumber , int pay);

    List<OrderList> queryAll(String userName);
}
