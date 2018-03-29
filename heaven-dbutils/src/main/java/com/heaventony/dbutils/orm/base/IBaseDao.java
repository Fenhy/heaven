package com.heaventony.dbutils.orm.base;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/4/7
 * Time: 下午5:11
 */
public interface IBaseDao<T> {

   /**
    * 直接保存对象
     * @param obj
    * @return
    */
   boolean save(Object obj);

   /**
    * sql语句保存
    * @param sql
    * @return
    */
   boolean save(String sql);

   /**
    * 通过对象删除
    * @param obj
    * @return
    */
   boolean delete(Object obj);

   /**
    * 通过sql删除
    * @param sql
    * @return
    */
   boolean delete(String sql);

   /**
    * 更新对象
    * @param object
    * @return
    */
   boolean update(Object object);

   /**
    * 通过sql更新
    * @param sql
    * @return
    */
   boolean update(String sql);

   /**
    * 返回所有列表
    * @return
    */
   List<T> findAll();

   /**
    * 对象查询
    * @param obj
    * @return
    */
   T queryObject(Object obj);

   /**
    * 通过sql查询对象
    * @param sql
    * @return
    */
   T query(String sql);

}
