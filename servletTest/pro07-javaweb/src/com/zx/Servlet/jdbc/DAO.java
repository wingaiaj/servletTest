package com.zx.Servlet.jdbc;


import com.zx.Servlet.jdbc.jdbc.utils.Close;
import com.zx.Servlet.jdbc.jdbc.utils.Connect;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @ClassName DAO
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/8 17:22
 * @Version 1.0
 */
public class DAO {
    public boolean update(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //获取连接
            connection = Connect.getConnection();
            //预编译sql语句
            preparedStatement = connection.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            //执行sql
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public <T> T getFruit(String sql, Class<T> clazz, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //获取连接
            connection = Connect.getConnection();
            //预编译sql语句
            preparedStatement = connection.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            //执行返回结果集
            resultSet = preparedStatement.executeQuery();
            //获取数据源
            ResultSetMetaData metaData = resultSet.getMetaData();
            //有数据
            if (resultSet.next()) {
                //创建对象
                T t = clazz.newInstance();
                //获取总列数
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    //获取列名
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    //通过列名获取值
                    Object object = resultSet.getObject(columnLabel);
                    //反射通过相同列名获取属性
                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    //设置为可编辑
                    declaredField.setAccessible(true);
                    //设置t对象 的值
                    declaredField.set(t, object);
                }
                //返回对象
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            Close.nowClose(connection, preparedStatement, resultSet);
        }
        return null;
    }
}
