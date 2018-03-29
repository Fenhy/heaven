package com.heaventony.dbutils.orm.base;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/4/7
 * Time: 下午5:30
 */
public class BaseDao implements IBaseDao{



    @Override
    public boolean save(Object obj) {
        return false;
    }

    @Override
    public boolean save(String sql) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    @Override
    public boolean delete(String sql) {
        return false;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean update(String sql) {
        return false;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Object queryObject(Object obj) {
        return null;
    }

    @Override
    public Object query(String sql) {
        return null;
    }
}
