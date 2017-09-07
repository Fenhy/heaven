package com.heaventony.security.service;

import com.heaventony.security.entity.User;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/8/22
 * Time: 下午10:54
 */
public interface IUserService {

    /**
     * 根据用户名获取用户信息
     * @param name
     * @return
     */
    User selectByName(String name);
    
}
