package me.merit.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import me.merit.entity.UserEntity;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    private static final int calendarField = Calendar.HOUR;
    private static String apiKey = "sf93q9)_rf2832QR%#$%Q@ae-rtae";
    private static String tokenExpiration = "24";

    public static String generateToken(UserEntity user) {
        Date iatDate = new Date();

        Calendar nowTime = Calendar.getInstance();
        int time;
        try {
            time = Integer.parseInt(tokenExpiration);
        } catch (Exception e) {
            time = 12;
        }
        nowTime.add(calendarField, time);
        Date expiresDate = nowTime.getTime();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        String token;

        try {
            token = JWT.create().withHeader(map)
                    .withClaim("user_id", user.getId())
                    .withClaim("role_id", user.getRoleId().toString())
                    .withIssuedAt(iatDate)
                    .withExpiresAt(expiresDate)
                    .sign(Algorithm.HMAC256(apiKey));
        } catch (Exception e) {
            return "";
        }
        return token;
    }

    public static UserEntity verifyToken(String token) {
        DecodedJWT jwt;
        UserEntity user = new UserEntity();

        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(apiKey)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            return null;
        }
        try {
            Map<String, Claim> claims = jwt.getClaims();
            user.setId(claims.get("user_id").asString());
            user.setRoleId(claims.get("role_id").asInt());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    public static String Md5(String payload) {
        try {
            MessageDigest md5= MessageDigest.getInstance("MD5");
            return (new BigInteger(1, md5.digest(payload.getBytes("utf-8")))).toString(16);
        } catch (Exception e) {
            return "";
        }
    }
}
