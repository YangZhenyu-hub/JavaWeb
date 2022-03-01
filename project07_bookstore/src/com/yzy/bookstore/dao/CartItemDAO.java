package com.yzy.bookstore.dao;

import com.yzy.bookstore.pojo.CartItem;
import com.yzy.bookstore.pojo.User;

import java.util.List;

/**
 * @ClassName CartItemDAO
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-28 11:04
 * @Version
 **/
public interface CartItemDAO {
    /**
     * 获取特定用户的购物车项
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 11:08 2022/2/28
     * @param  user
     * @return java.util.List<com.yzy.bookstore.pojo.CartItem>
     */
    List<CartItem> getCartItemList(User user);

    /**
     * 新增购物车项
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 11:33 2022/2/28
     * @param cartItem
     * @return void
     */
    int addCartItem(CartItem cartItem);
    /**
     * 修改购物车项
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 11:34 2022/2/28
     * @param cartItem
     * @return void
     */
    int updateCartItem(CartItem cartItem);

    /**
     * 删除购物车项
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 16:02 2022/2/28
     * @param cartItem
     * @return void
     */
    void delCartItem(CartItem cartItem);
}
