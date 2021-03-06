package site.luoyu.dao.mapper;

import site.luoyu.dao.entity.Orders;

import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String orderid);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    List<Orders> getAll();
}