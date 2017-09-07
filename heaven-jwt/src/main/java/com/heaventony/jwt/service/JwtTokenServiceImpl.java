package com.heaventony.jwt.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.joda.time.DateTime;

import java.util.Date;

import static io.jsonwebtoken.SignatureAlgorithm.HS512;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/8/10
 * Time: 下午10:40
 */
public class JwtTokenServiceImpl implements JwtTokenService {

    private static final String AUTHORITIES = "authorities";

    static final String SECRET = "ThisIsASecret";


    /**
     * 创建 jwt
     * @param id
     * @param subject
     * @param authorities
     * @param expire 过期时间，单位分钟
     * @return
     */
    public String createJwtToken(String id, String subject, String authorities, int expire) {
        Claims claims = Jwts.claims()
                .setId(id)
                .setSubject(subject)
                .setIssuedAt(new Date());
        if (expire > 0)
            claims.setExpiration(new DateTime(new Date()).plusMinutes(expire).toDate());
        claims.put(AUTHORITIES, authorities);
        return Jwts.builder()
                .setClaims(claims)
                .signWith(HS512, SECRET)
                .compact();
    }

    public Claims parseJwtToken(String jwtToken) throws Exception {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(jwtToken)
                .getBody();
        return claims;
    }

}
