package com.zx.Servlet;

import com.zx.Servlet.jdbc.DAO;
import com.zx.Servlet.jdbc.bean.Fruit;
import com.zx.Servlet.jdbc.fruitDAOImplement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName AddServlet
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/8 11:08
 * @Version 1.0
 */
public class AddServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //tomcat8之前 get方式获取中文数据的转码
//        String fName = request.getParameter("fName");
//        byte[] bytes = fName.getBytes("ISO-8859-1");
//        fName = new String(bytes, "UTF-8");
        //get方式下，不需要设置编码(基于tomcat8)
        //post方式下，设置编码，防止中文乱码
        //需要注意的是，设置编码这一句代码必须在所有的获取参数动作之前
        request.setCharacterEncoding("UTF-8");
        String fName = request.getParameter("fName");
        String p = request.getParameter("price");
        int price = Integer.parseInt(p);
        String f = request.getParameter("fCount");
        int fCount = Integer.parseInt(f);
        String remark = request.getParameter("remark");

        fruitDAOImplement fruitDAOImplement = new fruitDAOImplement();

        boolean insert = fruitDAOImplement.insert(new Fruit(fName, price, fCount, remark));
        System.out.println(insert ? "添加成功!" : "添加失败!");

    }

}
