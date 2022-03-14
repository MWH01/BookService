package com.kuang.service;

import com.kuang.dao.BookMapper;
import com.kuang.pojo.Book;

import java.util.List;

public class BookServiceImpl implements BookService{

    //service调用dao层
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public Book queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Book> queryAllBooks() {
        return bookMapper.queryAllBooks();
    }

    @Override
    public List<Book> queryBookByName(String bookName){
        return bookMapper.queryBookByName(bookName);
    }
}
