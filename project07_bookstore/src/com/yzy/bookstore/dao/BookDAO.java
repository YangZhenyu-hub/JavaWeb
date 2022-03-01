package com.yzy.bookstore.dao;

import com.yzy.bookstore.pojo.Book;

import java.util.List;

/**
 * @ClassName BookDAO
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-27 22:50
 * @Version
 **/
public interface BookDAO {
    /**
     * 首页获取图书列表
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 22:51 2022/2/27
     * @param
     * @return List<Book>
     */
    List<Book> getBookList();

    /**
     * 根据指定ID获取图书
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 22:56 2022/2/27
     * @param id
     * @return com.yzy.bookstore.pojo.Book
     */
    Book getBook(Integer id);
}
