package com.yzy.bookstore.pojo;

import java.math.BigDecimal;

/**
 * 购物车项类
 * @ClassName CartItem
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-27 12:02
 * @Version
 **/
public class CartItem {
    private Integer id;
    private Book book;
    private Integer buyCount;
    private User userBean;
    private Double xj;

    public CartItem() {
    }

    public CartItem(Book book, Integer buyCount, User userBean) {
        this.book = book;
        this.buyCount = buyCount;
        this.userBean = userBean;
    }

    public CartItem(Integer id) {
        this.id = id;
    }

    public CartItem(Integer cartItemId, Integer buyCount) {
        this.id = cartItemId;
        this.buyCount=buyCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public User getUserBean() {
        return userBean;
    }

    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }

    public Double getXj() {
        BigDecimal bigDecimalPrice = new BigDecimal(""+getBook().getPrice());
        BigDecimal bigDecimalBuyCount = new BigDecimal(""+buyCount);
        BigDecimal bigDecimalXJ = bigDecimalPrice.multiply(bigDecimalBuyCount);
        xj = bigDecimalXJ.doubleValue() ;
        return xj;
    }
}
