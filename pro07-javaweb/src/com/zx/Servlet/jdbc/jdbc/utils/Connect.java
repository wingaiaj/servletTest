package com.zx.Servlet.jdbc.jdbc.utils;

import javax.sql.DataSource;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @ClassName getConnection
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/8 17:27
 * @Version 1.0
 */
public class Connect {

    public static Connection getConnection() throws Exception {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";;
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1009555200");
        Connection connect = driver.connect(url, properties);
        return connect;
    }

}
