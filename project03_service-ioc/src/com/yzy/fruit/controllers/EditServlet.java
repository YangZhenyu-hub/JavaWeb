package com.yzy.fruit.controllers;

import com.yzy.fruit.dao.FruitDAO;
import com.yzy.fruit.dao.impl.FruitDAOImpl;
import com.yzy.fruit.pojo.Fruit;
import com.yzy.myssm.myspringmvc.ViewBaseServlet;
import com.yzy.myssm.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName EditServlet
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-20 10:33
 * @Version
 **/

@WebServlet("/edit.do")
public class EditServlet extends ViewBaseServlet {

    private FruitDAO fruitDAO=new FruitDAOImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fruitId = req.getParameter("fruitId");
        if (StringUtils.isNotEmpty(fruitId)) {
            int fid = Integer.parseInt(fruitId);
            Fruit fruit = fruitDAO.getFruitByFid(fid);
            req.setAttribute("fruit",fruit);
            super.processTemplate("edit",req,resp);
        }
    }
}
