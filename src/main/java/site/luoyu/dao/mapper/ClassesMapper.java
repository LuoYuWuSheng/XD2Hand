package site.luoyu.dao.mapper;

import site.luoyu.dao.entity.Classes;

public interface ClassesMapper {
    int deleteByPrimaryKey(Integer classId);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer classId);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}