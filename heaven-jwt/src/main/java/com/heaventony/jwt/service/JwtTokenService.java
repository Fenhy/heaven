package com.heaventony.jwt.service;

/**
 * Created with IntelliJ IDEA.
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/8/10
 * Time: 下午10:56
 */
public interface JwtTokenService {

    /**
     * 创建jwt token
     * @param id
     * @param subect
     * @param authorities
     * @param expire
     * @return
     */
    public String createJwtToken(String id, String subect, String authorities, int expire);
    
}
