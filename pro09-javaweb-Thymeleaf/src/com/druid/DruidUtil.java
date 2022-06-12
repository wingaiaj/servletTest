package com.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName DruidUtil
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/10 16:18
 * @Version 1.0
 */
public class DruidUtil {
    static DataSource dataSource = null;

    static {
        try {
            InputStream resourceAsStream = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties pt = new Properties();
            pt.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(pt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return dataSource.getConnection();
    }


    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
