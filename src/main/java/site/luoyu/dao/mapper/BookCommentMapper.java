package site.luoyu.dao.mapper;

import site.luoyu.dao.entity.BookComment;

public interface BookCommentMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(BookComment record);

    int insertSelective(BookComment record);

    BookComment selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(BookComment record);

    int updateByPrimaryKeyWithBLOBs(BookComment record);

    int updateByPrimaryKey(BookComment record);
}