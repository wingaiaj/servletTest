package com.DAO;

import com.bean.fruit;
import com.druid.DruidUtil;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DAO
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/10 15:38
 * @Version 1.0
 */
public abstract class DAO<T> {

    //创建子实现类时指定泛型参数
    private Class<T> clazz = null;

    //获取当前BaseDAO的子类继承的父类中的泛型
    {
        //获取当前对象父类的泛型类型 当前对象为实例化的子类
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();//获取了父类的泛型参数
        clazz = (Class<T>) actualTypeArguments[0];
    }

    //返回多条记录
    public List<T> getForList(Connection connection, String sql, Object... args) {
        //预编译sql
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                //填充占位符
                preparedStatement.setObject(i + 1, args[i]);
            }

            //执行sql返回结果集
            resultSet = preparedStatement.executeQuery();
            //获取元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //创建list集合 存放多个对象
            ArrayList<T> list = new ArrayList();

            //判断是否数据
            while (resultSet.next()) {
                //创建对象
                T t = clazz.newInstance();

                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    //获取列名
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    //回去列值
                    Object object = resultSet.getObject(i + 1);
                    //实例化指定泛型类 反射 通过列名获取对象属性
                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    //设置为可访问
                    declaredField.setAccessible(true);
                    //通过反射 给对象赋值
                    declaredField.set(t, object);
                }
                //将对象存入集合
                list.add(t);
            }
            //返回查询记录的集合
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.closeAll(null, preparedStatement, resultSet);
        }
        return null;
    }

    //update操作
    public boolean update(Connection connection, String sql, Object... args) {
        //预编译sql
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                //填充占位符
                preparedStatement.setObject(i + 1, args[i]);
            }
            //执行sql
            int i = preparedStatement.executeUpdate();
            //行数改变
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtil.closeAll(null, preparedStatement, null);
        }
        //没有行数
        return false;
    }
}
