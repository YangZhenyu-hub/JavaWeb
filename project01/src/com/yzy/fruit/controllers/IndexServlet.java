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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName IndexServlet
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-19 20:16
 * @Version
 **/

//Servlet从3.0版本开始支持注解注册
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
    FruitDAO fruitDAO=new FruitDAOImpl();

    /*
     * @Description TODO 查询表单的处理
     * @author yzy 729141789@qq.com
     * @Date 21:15 2022/2/20
     * @param req
     * @param resp
     * @return void
     **/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //因操作类似，转为doGet操作
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置编码
        req.setCharacterEncoding("utf-8");

        HttpSession session = req.getSession();
        int pageNum=1;
        String keyword=null;

        String operate = req.getParameter("operate");
        //operate!=null 则为查询表单过来的
        if (StringUtils.isNotEmpty(operate)&&"search".equals(operate))
        {
            //说明是表单点击过来的
            keyword = req.getParameter("keyword");
            pageNum=1;
            if (StringUtils.isEmpty(keyword)){
                //避免keyword为null
                keyword = "";
            }
            session.setAttribute("keyword",keyword);
        }else {
            //来自网址访问、页面按钮等操作
            String pageNumStr = req.getParameter("pageNum");
            if (StringUtils.isNotEmpty(pageNumStr)){
                pageNum = Integer.parseInt(pageNumStr);
            }
            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj!=null)
            {
                keyword=(String)keywordObj;
            } else{
                keyword = "";
            }
        }


        int fruitCount = fruitDAO.getFruitCount(keyword);
        int pageCount = (fruitCount + 5 - 1) / 5;


        session.setAttribute("pageNum",pageNum);
        session.setAttribute("pageCount",pageCount);
        List<Fruit> fruitList = fruitDAO.getFruitList(keyword,pageNum);

        //保存到session作用域
        //req.getSession：第一次访问分配一个SessionId,反之查询当前session
        session.setAttribute("fruitList",fruitList);

        //此处的视图名称是 index
        //那么thymeleaf会将这个 逻辑视图名称 对应到 物理视图 名称上去
        //逻辑视图名称 ：   index
        //物理视图名称 ：   view-prefix + 逻辑视图名称 + view-suffix
        //所以真实的视图名称是：      /       index       .html
        super.processTemplate("index",req,resp);
    }
}
