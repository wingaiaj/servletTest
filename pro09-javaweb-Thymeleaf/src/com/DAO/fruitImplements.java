package com.DAO;

import com.bean.fruit;

import java.sql.Connection;
import java.util.List;

/**
 * @ClassName fruitImplements
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/10 15:39
 * @Version 1.0
 */
public class fruitImplements extends DAO<fruit> implements FruitInterfaceDAO {

    @Override
    public void insertFruit(Connection connection, fruit f) {
        String sql = "insert into fruit(fname,price,fCount,remark) values(?,?,?,?)";
        update(connection, sql, f.getfName(), f.getPrice(), f.getfCount(), f.getremark());
    }

    @Override
    public List<fruit> selectFruit(Connection connection) {
        String sql = "select fname as fName,price,fCount,remark from fruit";
        List<fruit> forList = getForList(connection, sql);
        return forList;
    }

    @Override
    public boolean updateFruit(Connection connection, fruit f, String name) {
        String sql = "update fruit set fname=?,price=?,fCount=?,remark=? where fname = ?";
        boolean update = update(connection, sql, f.getfName(), f.getPrice(), f.getfCount(), f.getremark(), name);
        return update;
    }

    @Override
    public boolean deleteNameFruit(Connection connection, String name) {
        String sql = "delete from fruit where name = ?";
        boolean update = update(connection, sql, name);
        return update;
    }
}
