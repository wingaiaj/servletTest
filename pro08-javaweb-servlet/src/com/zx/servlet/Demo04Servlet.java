package com.zx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName Demo04Servlet
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/9 19:56
 * @Version 1.0
 */
public class Demo04Servlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //根据会话 来保存key value
        req.getSession().setAttribute("dina","evil");
    }
}
