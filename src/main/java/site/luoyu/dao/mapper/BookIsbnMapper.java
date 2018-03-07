package site.luoyu.dao.mapper;

import site.luoyu.dao.entity.BookIsbn;
import site.luoyu.dao.entity.BookIsbnWithBLOBs;

public interface BookIsbnMapper {
    int deleteByPrimaryKey(Long isbnId);

    int insert(BookIsbnWithBLOBs record);

    int insertSelective(BookIsbnWithBLOBs record);

    BookIsbnWithBLOBs selectByPrimaryKey(Long isbnId);

    int updateByPrimaryKeySelective(BookIsbnWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BookIsbnWithBLOBs record);

    int updateByPrimaryKey(BookIsbn record);

    BookIsbnWithBLOBs findByIsbn13(String isbn13);
}