package com.heaventony.jwt.service;

import io.jsonwebtoken.Claims;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/8/16
 * Time: 下午6:23
 */
public class JwtTokenServiceImplTest {
    
    JwtTokenServiceImpl jwtTokenServiceImpl = new JwtTokenServiceImpl();

    @Test
    public void testCreateJwtToken() {
        String result = jwtTokenServiceImpl.createJwtToken("id", "subject", "admin", 0);
        Assert.assertNotNull(result);
//        Assert.assertEquals(result, "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJpZCIsInN1YiI6InN1YmplY3QiLCJpYXQiOjE1MDI4NzkzOTAsImF1dGhvcml0aWVzIjoiYWRtaW4ifQ.8za_vruRhWNowu3cQdor-rCBwcGSq0mlal1Tb21fYrHDGm8m4iGIoAO1tR91ym53oi7kld-bATsye812aH1Vuw");
    }

    @Test
    public void testParseJwtToken() {
        Claims result = null;
        try {
            result = jwtTokenServiceImpl.parseJwtToken("eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJpZCIsInN1YiI6InN1YmplY3QiLCJpYXQiOjE1MDI4NzkzOTAsImF1dGhvcml0aWVzIjoiYWRtaW4ifQ.8za_vruRhWNowu3cQdor-rCBwcGSq0mlal1Tb21fYrHDGm8m4iGIoAO1tR91ym53oi7kld-bATsye812aH1Vuw");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(result.getId(), "id");
        Assert.assertEquals(result.get("authorities"), "admin");
    }
}

