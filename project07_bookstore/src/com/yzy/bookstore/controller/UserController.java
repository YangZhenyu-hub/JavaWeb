package com.yzy.bookstore.controller;

import com.yzy.bookstore.pojo.Cart;
import com.yzy.bookstore.pojo.User;
import com.yzy.bookstore.service.CartItemService;
import com.yzy.bookstore.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-27 21:52
 * @Version
 **/
public class UserController {

    private UserService userService;
    private CartItemService cartItemService;

    public String login(String uname, String pwd, HttpSession session) {
        User user = userService.login(uname, pwd);
        if (user != null) {
            Cart cart = cartItemService.getCart(user);
            user.setCart(cart);
            session.setAttribute("currUser",user);
            return "redirect:book.do";
        }
        return "index";
    }

    public String regist(String verifyCode , String uname , String pwd , String email , HttpSession session , HttpServletResponse response) throws IOException {
        Object kaptchaSessionKey = session.getAttribute("KAPTCHA_SESSION_KEY");
        if (kaptchaSessionKey == null || !verifyCode.equals(kaptchaSessionKey)) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            //out.println("<script language='javascript'>alert('验证码不正确！');window.location.href='page.do?operate=page&page=user/regist';</script>");
            out.println("<script language='javascript'>alert('验证码不正确！');</script>");
            //return "user/regist";
            return "user/regist";
        }else {
            if (verifyCode.equals(kaptchaSessionKey)){

                userService.regist(new User(uname , pwd , email,0));
                return "user/login";
            }
        }
        return "user/login";
    }


    public String ckUname(String uname) {
        User user = userService.getUser(uname);
        if (user != null) {
            //用户名已经被占用，不可以注册
            return "json:{'uname':'1'}";
        }
        else {
            return "json:{'uname':'0'}";
        }
    }
}
