package com.kuang.dao;

import java.util.List;

import com.kuang.pojo.Book;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {
    //增加一本书
    int addBook(Book book);
    //删除一本书
    int deleteBookById(@Param("bookId") int id);
    //修改一本书
    int updateBook(Book book);
    //查询一本书
    Book queryBookById(@Param("bookId") int id);
    //查询所有的书
    List<Book> queryAllBooks();
    //按名称模糊查询书籍
    List<Book> queryBookByName(@Param("bookName") String bookName);
}
