package com.zx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName Demo03Servlet
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/9 19:20
 * @Version 1.0
 */
public class Demo03Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session，如果获取不到则创建新的
        HttpSession session = request.getSession();
        System.out.println(session.getId());
    }
}
