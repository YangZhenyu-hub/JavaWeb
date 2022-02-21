package com.yzy.fruit.servlets;

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
 * @ClassName AddServlet
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-20 15:37
 * @Version
 **/
@WebServlet("/add.do")
public class AddServlet extends ViewBaseServlet {
    FruitDAO fruitDAO=new FruitDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String fname = req.getParameter("fname");
        String priceStr = req.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = req.getParameter("fcount");
        int fcount = Integer.parseInt(fcountStr);
        String remark = req.getParameter("remark");

        boolean insertFlag = fruitDAO.addFruit(new Fruit(0, fname, price, fcount, remark));
        if (insertFlag)
        {
            resp.sendRedirect("index");
        }
    }
}
