package site.luoyu.dao.mapper;

import org.apache.ibatis.annotations.Param;
import site.luoyu.dao.entity.UserStudent;

public interface UserStudentMapper {
    int deleteByPrimaryKey(Integer stuId);

    int insert(UserStudent record);

    int insertSelective(UserStudent record);

    UserStudent selectByPrimaryKey(Integer stuId);

    int updateByPrimaryKeySelective(UserStudent record);

    int updateByPrimaryKey(UserStudent record);

    UserStudent userLogin(@Param("name") String name, @Param("passwd") String passwd);
}