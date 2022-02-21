package com.yzy.fruit.servlets;

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
 * @ClassName DelServlet
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-20 15:13
 * @Version
 **/
@WebServlet("/del.do")
public class DelServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO=new FruitDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidStr = req.getParameter("fid");
        if (StringUtils.isNotEmpty(fidStr)){
            int fid = Integer.parseInt(fidStr);
            if(fruitDAO.delFruit(fid)){
                resp.sendRedirect("index");
            }
        }
    }
}
