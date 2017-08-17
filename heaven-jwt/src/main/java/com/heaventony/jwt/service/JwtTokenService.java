package com.heaventony.jwt.service;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/8/10
 * Time: 下午10:56
 */
public interface JwtTokenService {

    public String createJwtToken(String id, String subect, String authorities, int expire);
}
