package com.yzy.fruit.controllers;

import com.yzy.fruit.service.FruitService;
import com.yzy.fruit.pojo.Fruit;
import com.yzy.myssm.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName FruitServlet
 * @Description TODO 将所有的servlet功能整合到一个中完成
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-21 19:21
 * @Version
 **/

public class FruitController {

    FruitService fruitService=null;

    /*
     * @Description TODO 更新操作
     * @author yzy 729141789@qq.com
     * @Date 17:27 2022/2/22
     * @param fid
     * @param fname
     * @param price
     * @param fcount
     * @param remark
     * @return java.lang.String
     **/
    private String update(Integer fid,String fname,Integer price,Integer fcount,String remark)  {
        //1.执行更新
        boolean updateFlag = fruitService.updateFruit(new Fruit(fid, fname, price, fcount, remark));
        //2.资源跳转
        if (updateFlag){
            return "redirect:fruit.do";
        }
        return "error";

    }


    /*
     * @Description TODO 编辑操作
     * @author yzy 729141789@qq.com
     * @Date 17:30 2022/2/22
     * @param fid
     * @param req
     * @return java.lang.String
     **/
    private String edit(Integer fid,HttpServletRequest req) {
        if (fid!=null) {
            Fruit fruit = fruitService.getFruitByFid(fid);
            req.setAttribute("fruit",fruit);
            return "edit";
        }
        return "error";
    }



    /*
     * @Description TODO 删除操作
     * @author yzy 729141789@qq.com
     * @Date 17:32 2022/2/22
     * @param fid
     * @return java.lang.String
     **/
    private String del(Integer fid){
        if (fid!=null){
            if(fruitService.delFruit(fid)){
                return "redirect:fruit.do";
            }
        }
        return "error";
    }


    /*
     * @Description TODO 添加功能
     * @author yzy 729141789@qq.com
     * @Date 17:34 2022/2/22
     * @param fname
     * @param price
     * @param fcount
     * @param remark
     * @return java.lang.String
     **/
    private String add(String fname,Integer price,Integer fcount,String remark){

        boolean insertFlag = fruitService.addFruit(new Fruit(0, fname, price, fcount, remark));
        if (insertFlag)
        {
            return "redirect:fruit.do";
        }
        return "error";
    }



    private String index(String operate,String keyword,Integer pageNum,HttpServletRequest req) {

        HttpSession session = req.getSession();

        if (pageNum == null) {
            pageNum=1;
        }
        if (StringUtils.isNotEmpty(operate)&&"search".equals(operate))
        {
            //说明是表单点击过来的
            pageNum=1;
            if (StringUtils.isEmpty(keyword)){
                //避免keyword为null
                keyword = "";
            }
            session.setAttribute("keyword",keyword);
        }else {
            //来自网址访问、页面按钮等操作
            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj!=null)
            {
                keyword=(String)keywordObj;
            } else{
                keyword = "";
            }
        }

        int pageCount = fruitService.getPageCount(keyword);

        session.setAttribute("pageNum",pageNum);
        session.setAttribute("pageCount",pageCount);

        List<Fruit> fruitList = fruitService.getFruitList(keyword,pageNum);

        //保存到session作用域
        //req.getSession：第一次访问分配一个SessionId,反之查询当前session
        session.setAttribute("fruitList",fruitList);

        //此处的视图名称是 index
        //那么thymeleaf会将这个 逻辑视图名称 对应到 物理视图 名称上去
        //逻辑视图名称 ：   index
        //物理视图名称 ：   view-prefix + 逻辑视图名称 + view-suffix
        //所以真实的视图名称是：      /       index       .html
        return "index";
    }
}
