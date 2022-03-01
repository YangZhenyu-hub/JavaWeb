package com.yzy.bookstore.dao.impl;

import com.yzy.bookstore.dao.CartItemDAO;
import com.yzy.bookstore.pojo.CartItem;
import com.yzy.bookstore.pojo.User;
import com.yzy.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @ClassName CartItemDAO
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-28 11:02
 * @Version
 **/
public class CartItemDAOImpl extends BaseDAO<CartItem> implements CartItemDAO {
    @Override
    public List<CartItem> getCartItemList(User user) {
        return super.executeQuery("select * from t_cart_item where userBean=?", user.getId());
    }

    @Override
    public int addCartItem(CartItem cartItem) {
        return super.executeUpdate("insert t_cart_item values(0,?,?,?)",cartItem.getBook().getId(),cartItem.getBuyCount(),cartItem.getUserBean().getId());
    }

    @Override
    public int updateCartItem(CartItem cartItem) {
        return super.executeUpdate("update t_cart_item set buyCount =? where id=?",cartItem.getBuyCount(),cartItem.getId());
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        super.executeUpdate("delete from t_cart_item where id=?", cartItem.getId());
    }


}
