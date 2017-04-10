package com.heaventony.dbutils.orm.base;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/4/7
 * Time: 下午5:11
 */
public interface IBaseDao<T> {

   boolean save(Object obj);

   boolean save(String sql);

   boolean delete(Object obj);

   boolean delete(String sql);

   boolean update(Object object);

   boolean update(String sql);

   List<T> findAll();

   T queryObject(Object obj);

   T query(String sql);

}
