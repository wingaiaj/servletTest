package com.DAO;

import com.bean.fruit;

import java.sql.Connection;
import java.util.List;

/**
 * @ClassName FruitInterfaceDAO
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/10 15:38
 * @Version 1.0
 */
public interface FruitInterfaceDAO {

    //插入记录
    void insertFruit(Connection connection, fruit f);
    //查询记录
    List<fruit> selectFruit(Connection connection);
    //更新数据
    boolean updateFruit(Connection connection,fruit f,String name);
    //删除
    boolean deleteNameFruit(Connection connection,String name);
}
