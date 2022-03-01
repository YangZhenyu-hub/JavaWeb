package com.yzy.bookstore.service;

import com.yzy.bookstore.pojo.Cart;
import com.yzy.bookstore.pojo.CartItem;
import com.yzy.bookstore.pojo.User;

import java.util.List;

/**
 * @ClassName cartItemService
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-28 10:34
 * @Version
 **/
public interface CartItemService {


   /**
    *  //获取指定用户的所有购物车项列表（需要注意的是，这个方法内部查询的时候，会将book的详细信息设置进去）
    * @Description TODO
    * @author yzy 729141789@qq.com
    * @Date 11:11 2022/2/28
    * @param user
    * @return List<CartItem>
    */
    List<CartItem> getCartItemList(User user);

    /**
     * 获取指定用户的购物车
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 10:57 2022/2/28
     * @param user
     * @return com.yzy.bookstore.pojo.Cart
     */
    Cart getCart(User user);

    /**
     * 添加购物车项
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 11:31 2022/2/28
     * @param cartItem
     * @return void
     */
    void addCartItem(CartItem cartItem);

    /**
     * 更新购物车项
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 11:31 2022/2/28
     * @param cartItem
     * @return void
     */
    void updateCartItem(CartItem cartItem);

    /**
     * 修改购物车项（根据实际情况新增或修改）
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 11:32 2022/2/28
     * @param cartItem
     * @param cart
     * @return void
     */
    void addOrUpdateCartItem(CartItem cartItem , Cart cart);


}
