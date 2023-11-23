package com.cmsbackend.utils.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {


    private static  String secretKey = "cms";
    private static long expiration = 86400000;
    static {
        // 这里可以是硬编码的值，或者从配置文件中读取
        secretKey = "cms"; // 请替换为您的密钥
    }

    public String generateToken(String account) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);
        System.out.println(secretKey);
        System.out.println(3);

        return Jwts.builder()
                .setSubject(account)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public static String getUserAccountFromToken(String token) {
        System.out.println(secretKey);
        System.out.println(2);

        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public static Jws<Claims> validateToken(String token) {
        System.out.println(secretKey);
        System.out.println(1);

        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
    }
}
