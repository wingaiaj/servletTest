package com.zx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName Demo05Servlet
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/9 19:56
 * @Version 1.0
 */
public class Demo05Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //根据会话来获取  容器里会话的值
        Object dina = request.getSession().getAttribute("dina");
        System.out.println(request.getSession().getId());
        System.out.println(dina);
    }
}
