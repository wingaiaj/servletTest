package com.zx.DAO;


import com.zx.bean.Fruit;

import java.sql.Connection;
import java.util.List;

/**
 * @ClassName FruitDAOImp
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/11 15:47
 * @Version 1.0
 */
public class FruitDAOImp extends BaseDAO<Fruit> implements FruitDAO {
    //添加一条记录
    @Override
    public boolean addFruit(Connection connection, Fruit fruit) {
        String sql = "insert into fruit(fname as 'fName',price,fCount as 'count',remark) values(?,?,?,?)";
        boolean update = update(connection, sql, fruit.getFid(), fruit.getfName(), fruit.getPrice(), fruit.getCount(), fruit.getRemark());
        return update;
    }

    //获取所有水果数据
    @Override
    public List<Fruit> getAllFruit(Connection connection) {
        String sql = "select fid,fname as 'fName',price,fCount as'count',remark from fruit";
        List<Fruit> listRecord = getListRecord(connection, sql);
        return listRecord;
    }

    //比输入价格高的多条水果数据
    @Override
    public List<Fruit> getFruitList(Connection connection, Integer price) {
        String sql = "select fid,fname as 'fName',price,fCount as 'count',remark from fruit where price <?";
        List<Fruit> listRecord = getListRecord(connection, sql, price);
        return listRecord;
    }

    //修改指定水果数据根据id
    @Override
    public boolean alterFruit(Connection connection, Fruit fruit) {
        String sql = "update fruit set fname=?,price=?,fCount=?,remark=? where fid = ?";
        boolean update = update(connection, sql, fruit.getfName(), fruit.getPrice(), fruit.getCount(), fruit.getRemark(), fruit.getFid());
        return update;
    }

    //获取指定名字水果数据
    @Override
    public Fruit getFruit(Connection connection, Integer fid) {
        String sql = "select fid,fname as 'fName',price,fCount as 'count',remark from fruit where fid =?";
        Object record = getRecord(connection, sql, fid);
        return (Fruit) record;
    }

    @Override
    public boolean deleteFruit(Connection connection, Integer fid) {
        String sql = "delete from fruit where fid =? ";
        return update(connection, sql, fid);
    }
}
