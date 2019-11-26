package com.datangedu.cn.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.datangedu.cn.model.sysUser.OrderList;
import com.datangedu.cn.model.sysUser.OrderListExample;
@Mapper
public interface OrderListMapper {
    long countByExample(OrderListExample example);

    int deleteByExample(OrderListExample example);

    int deleteByPrimaryKey(int id);

    int insert(OrderList record);

    int insertSelective(OrderList record);

    List<OrderList> selectByExample(OrderListExample example);

    OrderList selectByPrimaryKey(int id);

    int updateByExampleSelective(@Param("record") OrderList record, @Param("example") OrderListExample example);

    int updateByExample(@Param("record") OrderList record, @Param("example") OrderListExample example);

    int updateByPrimaryKeySelective(OrderList record);

    int updateByPrimaryKey(OrderList record);

    void updateOrder(OrderList orderList);

    List<OrderList> queryAll(String userName);
}