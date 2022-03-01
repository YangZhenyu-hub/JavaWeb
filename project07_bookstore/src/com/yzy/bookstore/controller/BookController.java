package com.yzy.bookstore.controller;

import com.yzy.bookstore.pojo.Book;
import com.yzy.bookstore.service.BookService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName BookController
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-27 22:50
 * @Version
 **/
public class BookController {
    private BookService bookService;

    public String index(HttpSession session) {
        List<Book> bookList = bookService.getBookList();
        session.setAttribute("bookList",bookList);
        return "index";

    }
}
