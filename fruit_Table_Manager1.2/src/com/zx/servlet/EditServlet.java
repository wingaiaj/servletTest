package com.zx.servlet;

import com.zx.DAO.FruitDAO;
import com.zx.DAO.FruitDAOImp;
import com.zx.bean.Fruit;
import com.zx.util.StringUtils;
import com.zx.util.jdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName EditServlet
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/12 19:59
 * @Version 1.0
 */
@WebServlet("/edit.do")
public class EditServlet extends ViewBaseServlet {
    //创建fruitDao实现类
    FruitDAO fruitDAO = new FruitDAOImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String fidStr = request.getParameter("fid");
        if (StringUtils.isNotEmpty(fidStr)) {
            try {
                //获取连接
                Connection connection = jdbcUtils.getConnection();
                //转换为int类型
                int fid = Integer.parseInt(fidStr);
                //调用根据节id获取水果方法
                Fruit fruit = fruitDAO.getFruit(connection, fid);
                //将参数设置在请求作用域中
                request.setAttribute("fruit", fruit);
                //真实物理视图
                super.processTemplate("edit", request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
