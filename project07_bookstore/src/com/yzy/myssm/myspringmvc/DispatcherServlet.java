package com.yzy.myssm.myspringmvc;

import com.yzy.myssm.ioc.BeanFactory;
import com.yzy.myssm.utils.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @ClassName DispatcherServlet
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-24 21:55
 * @Version
 **/
@WebServlet("*.do")
public class DispatcherServlet extends ViewBaseServlet{
    private BeanFactory beanFactory;

    public DispatcherServlet() {

    }


    @Override
    public void init() throws ServletException {
        super.init();
        //从application作用域中去获取IOC容器
        ServletContext application = getServletContext();
        Object beanFactoryObj = application.getAttribute("beanFactory");
        if (beanFactoryObj != null) {
            beanFactory = (BeanFactory) beanFactoryObj;
        }else {
            throw new DispatcherServletException("IOC容器获取失败");
        }

    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        //request.setCharacterEncoding("UTF-8");
        //假设url是：  http://localhost:8080/pro15/hello.do
        //那么servletPath是：    /hello.do
        // 我的思路是：
        // 第1步： /hello.do ->   hello   或者  /fruit.do  -> fruit
        // 第2步： hello -> HelloController 或者 fruit -> FruitController
        String servletPath = req.getServletPath();
        int lastIndexOf = servletPath.lastIndexOf(".do");
        servletPath=servletPath.substring(1, lastIndexOf);

        Object controllerBeanObj = beanFactory.getBean(servletPath);

        String operate = req.getParameter("operate");
        if (StringUtils.isEmpty(operate)) {
            operate = "index";
        }

        try {
            Method[] methods = controllerBeanObj.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (operate.equals(method.getName())) {
                    //1.统一获取请求参数

                    //1.1获取当前方法的参数
                    Parameter[] parameters = method.getParameters();
                    //1.2paramaterValues承载参数的值
                    Object[] parameterValues = new Object[parameters.length];
                    for (int i = 0; i < parameters.length; i++) {
                        Parameter parameter = parameters[i];
                        String parameterName = parameter.getName();
                        if ("req".equals(parameterName)) {
                            parameterValues[i]=req;
                        } else if ("resp".equals(parameterName)) {
                            parameterValues[i]=resp;
                        }else if ("session".equals(parameterName)) {
                            parameterValues[i] =req.getSession();
                        }else {
                            //从请求中获取参数
                            String parameterValue = req.getParameter(parameterName);
                            //参数类型的名称
                            String typeName = parameter.getType().getName();
                            Object parameterObj=parameterValue;

                            if (parameterObj != null) {
                                if ("java.lang.Integer".equals(typeName)) {
                                    parameterObj = Integer.parseInt(parameterValue);
                                }
                            }
                            parameterValues[i] =parameterObj;

                        }
                    }

                    //2.controller组件中的方法调用
                    method.setAccessible(true);
                    Object returnObj = method.invoke(controllerBeanObj, parameterValues);

                    //3.视图处理
                    String methodReturnStr = (String) returnObj;
                    if (StringUtils.isEmpty(methodReturnStr)) {
                        return;
                    }
                    if (methodReturnStr.startsWith("redirect:")) {
                        String redirectStr = methodReturnStr.substring("redirect:".length());
                        resp.sendRedirect(redirectStr);
                    }else if(methodReturnStr.startsWith("json:")){
                        resp.setCharacterEncoding("UTF-8");
                        resp.setContentType("application/json");
                        String jsonStr = methodReturnStr.substring("json:".length());
                        PrintWriter out = resp.getWriter();
                        out.print(jsonStr);
                        out.flush();
                    }else {
                        super.processTemplate(methodReturnStr,req,resp);
                    }

                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
