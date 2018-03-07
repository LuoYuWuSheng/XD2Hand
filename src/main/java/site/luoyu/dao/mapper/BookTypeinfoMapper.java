package site.luoyu.dao.mapper;

import site.luoyu.dao.entity.BookTypeinfo;

public interface BookTypeinfoMapper {
    int deleteByPrimaryKey(Integer booktypeid);

    int insert(BookTypeinfo record);

    int insertSelective(BookTypeinfo record);

    BookTypeinfo selectByPrimaryKey(Integer booktypeid);

    int updateByPrimaryKeySelective(BookTypeinfo record);

    int updateByPrimaryKey(BookTypeinfo record);
}