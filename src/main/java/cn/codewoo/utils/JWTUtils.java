package cn.codewoo.utils;

import cn.codewoo.entity.User;
import cn.codewoo.exception.BusinessException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author kehong
 * jwt工具类
 */
public class JWTUtils {
    /**
     * 过期事件
     */
    private final static long EXPIRE = 6000*24*7;
    /**
     * 加密秘钥
     */
    private static final String SECRET = "cn.codewoo";
    /**
     * 令牌前缀
     */
    private static final String TOKEN_PREFIX = "kehong";
    /**
     * 主体
     */
    private static final String SUBJECT = "kehong";

    public static String geneJsonWebToken(User user){
        String token = Jwts.builder()
                .setSubject(SUBJECT)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("head_img", user.getHeadImg())
                .claim("name", user.getName())
                .claim("id", user.getId())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();
        token += TOKEN_PREFIX;
        return token;
    }

    public static Claims checkToken(String token){
        try{
            Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();
            return claims;
        }catch (Exception e){
            throw new BusinessException(BaseRespCodeImpl.AUTHENTICATED_ERROR);
        }
    }

    public static Integer getId(String token){
        Claims claims = checkToken(token);
        return claims.get("id",Integer.class);
    }
}
