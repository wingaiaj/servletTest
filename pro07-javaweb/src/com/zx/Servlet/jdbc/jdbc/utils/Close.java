package com.zx.Servlet.jdbc.jdbc.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName colse
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/8 17:44
 * @Version 1.0
 */
public class Close {
    public static void nowClose(Connection connection, Statement statement, ResultSet resultSet){
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
