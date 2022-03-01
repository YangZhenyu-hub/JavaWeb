package com.yzy.bookstore.controller;

import com.google.gson.Gson;
import com.yzy.bookstore.pojo.Book;
import com.yzy.bookstore.pojo.Cart;
import com.yzy.bookstore.pojo.CartItem;
import com.yzy.bookstore.pojo.User;
import com.yzy.bookstore.service.CartItemService;

import javax.servlet.http.HttpSession;

/**
 * @ClassName CartController
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-28 10:05
 * @Version
 **/
public class CartController {

    private CartItemService cartItemService;

    private String index(HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        user.setCart(cart);
        session.setAttribute("currUser",user);
        return "cart/cart";
    }

    /**
     * 添加指定图书到购物车
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 10:06 2022/2/28
     * @param bookId
     * @return java.lang.String
     */

    public String addCart(Integer bookId, HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        //根据指定图书创建cartItem对象
        CartItem cartItem = new CartItem(new Book(bookId), 1, user);
        cartItemService.addOrUpdateCartItem(cartItem, user.getCart());
        return "redirect:cart.do";
    }

    public String editCart(Integer cartItemId, Integer buyCount) {
        cartItemService.updateCartItem(new CartItem(cartItemId , buyCount));
        return "";
    }

    public String cartInfo(HttpSession session) {
        User user = (User)session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);

        //调用Cart中的三个属性的get方法，目的是在此处计算这三个属性的值，否则这三个属性为null，
        //导致的结果就是下一步的gson转化时，为null的属性会被忽略
        cart.getTotalBookCount();
        cart.getTotalCount();
        cart.getTotalMoney();

        Gson gson = new Gson();
        String cartJsonStr = gson.toJson(cart);
        return "json:"+cartJsonStr;

    }
}
