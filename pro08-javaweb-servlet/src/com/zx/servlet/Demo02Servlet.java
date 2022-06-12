package com.zx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName Demo02Servlet
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/9 17:04
 * @Version 1.0
 */
public class Demo02Servlet extends HttpServlet {
    public Demo02Servlet() {
        System.out.println("正在实例化......");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("正在初始化......");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("正在服务.....");
    }

    @Override
    public void destroy() {
        System.out.println("正在销毁....");
    }
}
