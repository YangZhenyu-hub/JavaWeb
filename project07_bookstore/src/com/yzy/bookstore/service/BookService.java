package com.yzy.bookstore.service;

import com.yzy.bookstore.pojo.Book;

import java.util.List;

/**
 * @ClassName BookService
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-27 23:03
 * @Version
 **/
public interface BookService {
    /**
     * 获取图书列表的Service
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 23:04 2022/2/27
     * @param
     * @return List<Book>
     */
    List<Book> getBookList();

    /**
     * 根据指定的ID获取图书
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 23:04 2022/2/27
     * @param id
     * @return com.yzy.bookstore.pojo.Book
     */
    Book getBook(Integer id);
}
