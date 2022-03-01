package com.yzy.bookstore.service.impl;

import com.yzy.bookstore.dao.BookDAO;
import com.yzy.bookstore.pojo.Book;
import com.yzy.bookstore.service.BookService;

import java.util.List;

/**
 * @ClassName BookServiceImpl
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-27 23:05
 * @Version
 **/
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }

    @Override
    public Book getBook(Integer id) {
        return bookDAO.getBook(id);
    }
}
