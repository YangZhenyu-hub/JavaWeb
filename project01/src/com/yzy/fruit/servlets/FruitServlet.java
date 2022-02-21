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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @ClassName FruitServlet
 * @Description TODO 将所有的servlet功能整合到一个中完成
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-21 19:21
 * @Version
 **/

@WebServlet("/fruit.do")
public class FruitServlet extends ViewBaseServlet {

    FruitDAO fruitDAO=new FruitDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");

        String operation = req.getParameter("operation");

        if (StringUtils.isEmpty(operation)) {
            operation="index";
        }

        //方式二：根据方法名反射
        Method[] methods = this.getClass().getDeclaredMethods();
        for(Method method:methods){
            String methodName = method.getName();
            if (operation.equals(methodName)) {
                try {
                    method.invoke(this, req, resp);
                    return;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new RuntimeException("operation不合法");


        //方式一： 缺点：当operation很多时，switch很长
//        switch (operation) {
//            case "index":
//                index(req,resp);
//                break;
//            case "add":
//                add(req,resp);
//                break;
//            case "del":
//                del(req, resp);
//                break;
//            case "edit":
//                edit(req, resp);
//                break;
//            case "update":
//                update(req, resp);
//                break;
//            default:
//                throw new RuntimeException("operation不合法");
//        }


    }


    /*
     * @Description TODO 更新操作
     * @author yzy 729141789@qq.com
     * @Date 19:53 2022/2/21
     * @param req
     * @param resp
     * @return void
     **/
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            resp.sendRedirect("fruit.do");

        }


    }

    /*
     * @Description TODO 编辑界面
     * @author yzy 729141789@qq.com
     * @Date 19:52 2022/2/21
     * @param req
     * @param resp
     * @return void
     **/
    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fruitId = req.getParameter("fruitId");
        if (StringUtils.isNotEmpty(fruitId)) {
            int fid = Integer.parseInt(fruitId);
            Fruit fruit = fruitDAO.getFruitByFid(fid);
            req.setAttribute("fruit",fruit);
            super.processTemplate("edit",req,resp);
        }
    }


    /*
     * @Description TODO 删除操作
     * @author yzy 729141789@qq.com
     * @Date 19:51 2022/2/21
     * @param req
     * @param resp
     * @return void
     **/
    private void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidStr = req.getParameter("fid");
        if (StringUtils.isNotEmpty(fidStr)){
            int fid = Integer.parseInt(fidStr);
            if(fruitDAO.delFruit(fid)){
                resp.sendRedirect("fruit.do");
            }
        }
    }


    /*
     * @Description TODO 增加操作
     * @author yzy 729141789@qq.com
     * @Date 19:50 2022/2/21
     * @param req
     * @param resp
     * @return void
     **/
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            resp.sendRedirect("fruit.do");
        }
    }


    /*
     * @Description TODO 查询显示功能
     * @author yzy 729141789@qq.com
     * @Date 19:39 2022/2/21
     * @param req
     * @param resp
     * @return void
     **/
    private void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
