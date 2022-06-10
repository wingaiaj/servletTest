package com.zx.Servlet.jdbc;
import com.zx.Servlet.jdbc.bean.Fruit;

import java.sql.Connection;

/**
 * @ClassName DAOInteface
 * @Description TODO
 * @Author xpower
 * @Date 2022/6/8 17:23
 * @Version 1.0
 */
public interface DAOFruitInTeFace{
    //查询水果对象
    Fruit getFruit( String name);
    //表中插入
    boolean insert(Fruit fruit);
}
