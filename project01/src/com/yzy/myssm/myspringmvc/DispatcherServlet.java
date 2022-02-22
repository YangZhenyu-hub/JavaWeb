package com.yzy.myssm.myspringmvc;

import com.yzy.fruit.controllers.FruitController;
import com.yzy.myssm.utils.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName DispatcherServlet
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-21 22:49
 * @Version
 **/
@WebServlet("*.do")
public class DispatcherServlet extends ViewBaseServlet{

    //存放xml的bean中 id 与 class 的映射  即 fruit 与 FruitController类的映射关系
    private Map<String, Object> beanMap = new HashMap<>();

    /*
    2)根据fruit找到对应的组件:FruitController ， 这个对应的依据我们存储在applicationContext.xml中
      <bean id="fruit" class="com.atguigu.fruit.controllers.FruitController/>
      通过DOM技术我们去解析XML文件，在中央控制器中形成一个beanMap容器，用来存放所有的Controller组件
     */
    public void init() throws ServletException {
        super.init();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("applicationContext.xml");
            //1.创建DocumentBuilderFactory
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            //2.创建DocumentBuilder对象
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            //3.创建Document对象
            Document document = documentBuilder.parse(inputStream);

            //4.获取所有的bean节点
            NodeList beanNodeList = document.getElementsByTagName("bean");
            for (int i = 0; i < beanNodeList.getLength(); i++) {
                Node beanNode = beanNodeList.item(i);
                if (beanNode.getNodeType()==Node.ELEMENT_NODE){
                    Element beanElement=(Element)beanNode;
                    String beanId = beanElement.getAttribute("id");
                    String className = beanElement.getAttribute("class");
                    //得到controllerBeanClass 类的 Class
                    Class controllerBeanClass = Class.forName(className);
                    //产生对应class的实例
                    Object beanObj = controllerBeanClass.newInstance();
                    //放入beanMap
                    beanMap.put(beanId,beanObj);
                }

            }
        }  catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");


        /*
           1.根据url定位到能够处理这个请求的controller组件：
            1)从url中提取servletPath : /fruit.do -> fruit
                假设url是：  http://localhost:8080/pro15/hello.do
                那么servletPath是：    /hello.do
                我的思路是：
                第1步： /hello.do ->   hello   或者  /fruit.do  -> fruit
                第2步： hello -> HelloController 或者 fruit ->FruitController
         */

        String servletPath = req.getServletPath();
        servletPath=servletPath.substring(1);
        int lastIndexOf = servletPath.lastIndexOf(".do");
        servletPath = servletPath.substring(0, lastIndexOf);

        Object controllerBeanObj = beanMap.get(servletPath);

        //获取具体操作的名称
        String operation = req.getParameter("operation");
        if (StringUtils.isEmpty(operation)) {
            operation = "index";
        }

        try {
            Method[] methods = controllerBeanObj.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (operation.equals(method.getName())) {
                    //1.统一获取请求参数

                    //1.1获取当前方法的参数 如：String keyword  int pageNum
                    Parameter[] parameters = method.getParameters();
                    Object[] parameterValues = new Object[parameters.length];
                    for (int i = 0; i < parameters.length; i++) {
                        Parameter parameter = parameters[i];
                        String parameterName = parameter.getName();
                        //如果参数名是request,response,session 那么就不是通过请求中获取参数的方式了
                        if ("req".equals(parameterName)) {
                            parameterValues[i]=req;
                        } else if ("resp".equals(parameterName)) {
                            parameterValues[i] = resp;
                        } else if ("session".equals(parameterName)) {
                            parameterValues[i]=req.getSession();
                        }else{
                            //从请求中获取参数值
                            String parameterValue = req.getParameter(parameterName);
                            String typeName = parameter.getType().getName();
                            Object parameterObj=parameterValue;
                            if (parameterObj != null) {
                                if ("java.lang.Integer".equals(typeName)) {
                                    parameterObj = Integer.parseInt(parameterValue);
                                }
                            }
                            parameterValues[i]=parameterObj;
                        }
                    }

                    //2.controller组件中的方法调用
                    method.setAccessible(true);
                    Object returnObj = method.invoke(controllerBeanObj, parameterValues);

                    //3.视图处理
                    String methodReturnStr=(String) returnObj;
                    if (methodReturnStr.startsWith("redirect:")){
                        //比如：  redirect:fruit.do
                        String redirectStr = methodReturnStr.substring("redirect:".length());
                        resp.sendRedirect(redirectStr);
                    }else {
                        super.processTemplate(methodReturnStr,req,resp);    // 比如：  "edit"
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
