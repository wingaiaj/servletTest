package com.zx.Servlet.jdbc;

import com.zx.Servlet.jdbc.bean.Fruit;

/**
 * @ClassName fruitDAOimplement
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/8 17:23
 * @Version 1.0
 */
public class fruitDAOImplement extends DAO implements DAOFruitInTeFace {
    @Override
    public Fruit getFruit(String name) {
        String sql = "select fname as fName,price,fCount,remark from fruit where name = ?";
        Fruit fruit = getFruit(sql, Fruit.class, name);
        return fruit;
    }

    @Override
    public boolean insert(Fruit fruit) {
        String sql = "insert into fruit(fname,price,fCount,remark) values(?,?,?,?)";
        boolean update = update(sql, fruit.getfName(), fruit.getPrice(), fruit.getfCount(), fruit.getRemark());
            return update;
    }
}
