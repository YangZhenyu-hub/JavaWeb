package com.yzy.fruit.controllers;

import com.yzy.fruit.dao.FruitDAO;
import com.yzy.fruit.dao.impl.FruitDAOImpl;
import com.yzy.fruit.pojo.Fruit;
import com.yzy.myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName UpdateServlet
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-20 14:15
 * @Version
 **/
@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {

    FruitDAO fruitDAO=new FruitDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        String fname = req.getParameter("fname");
        String priceStr = req.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = req.getParameter("fcount");
        int fcount = Integer.parseInt(fcountStr);
        String fidStr = req.getParameter("fid");
        int fid = Integer.parseInt(fidStr);
        String remark = req.getParameter("remark");

        boolean updateFlag = fruitDAO.updateFruite(new Fruit(fid, fname, price, fcount, remark));

        if (updateFlag){
//            //方法一：此做法并没有更新数据，index数据存在session中，没有发起再次请求，即数据没有更新
//            super.processTemplate("index",req,resp);
//            //方法二：资源跳转，与上一种方法等同
//            req.getRequestDispatcher("index.html").forward(req,resp);

            //方法三：重定向，重新发送请求，更新session中的数据
            resp.sendRedirect("index");

        }


    }
}
