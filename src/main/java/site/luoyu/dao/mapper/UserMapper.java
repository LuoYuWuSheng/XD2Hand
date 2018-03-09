package site.luoyu.dao.mapper;

import site.luoyu.dao.entity.User;

import javax.jws.soap.SOAPBinding;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(String name,String passwd);
}