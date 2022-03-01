package com.yzy.bookstore.dao.impl;

import com.yzy.bookstore.dao.BookDAO;
import com.yzy.bookstore.pojo.Book;
import com.yzy.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @ClassName BookDAOImpl
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-27 22:57
 * @Version
 **/
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public List<Book> getBookList() {
        return super.executeQuery("select * from t_book where bookStatus=0");
    }

    @Override
    public Book getBook(Integer id) {
        return super.load("select * from t_book where id=?", id);
    }
}
