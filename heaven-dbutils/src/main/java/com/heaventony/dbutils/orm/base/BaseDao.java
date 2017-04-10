package com.heaventony.dbutils.orm.base;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/4/7
 * Time: 下午5:30
 */
public class BaseDao implements IBaseDao{



    public boolean save(Object obj) {

        return false;
    }

    public boolean save(String sql) {
        return false;
    }

    public boolean delete(Object obj) {
        return false;
    }

    public boolean update(Object object) {
        return false;
    }

    public List findAll() {
        return null;
    }

    public Object queryObject(Object obj) {
        return null;
    }
}
