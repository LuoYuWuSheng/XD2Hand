package site.luoyu.dao.mapper;

import site.luoyu.dao.entity.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(String orderdetailid);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String orderdetailid);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}