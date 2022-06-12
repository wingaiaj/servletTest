package com.Servlet;

import com.DAO.FruitInterfaceDAO;
import com.DAO.fruitImplements;
import com.bean.fruit;
import com.druid.DruidUtil;
import com.myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * @ClassName IndexServlet
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/10 18:16
 * @Version 1.0
 */
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //fruitDAO接口的实现类对象
            fruitImplements fruitImplements = new fruitImplements();
            //获取连接
             Connection connection = DruidUtil.getConnection();
            //返回List集合
            List<fruit> fruits = fruitImplements.selectFruit(connection);
                //获取到session对象
            HttpSession session = request.getSession();
            //保存到session作用域
            session.setAttribute("fruits",fruits);
            //处理模板
            //此处的处理名称是index
            //那么thymeleaf会将这个 逻辑视图 对应到 物理视图 名称上去
            //逻辑视图名称: index
            //物理视图名称: view-prefix + 逻辑视图名称 + view-suffix
            //所以真实的视图名称是//
            super.processTemplate("index",request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
