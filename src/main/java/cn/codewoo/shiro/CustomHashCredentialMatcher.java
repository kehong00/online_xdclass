package cn.codewoo.shiro;

import cn.codewoo.exception.BusinessException;
import cn.codewoo.utils.BaseRespCodeImpl;
import cn.codewoo.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

/**
 * @author kehong
 * 自定义认证方法
 */
public class CustomHashCredentialMatcher extends HashedCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //获取携带的token
        String jwtToken = (String) info.getCredentials();
        //校验token
        Claims claims = JWTUtils.checkToken(jwtToken);
        if (claims == null){
            throw new BusinessException(BaseRespCodeImpl.NOT_LOGIN);
        }
        //校验token是否有效
        if (claims.getExpiration().getTime() < System.currentTimeMillis()){
            throw new BusinessException(BaseRespCodeImpl.LOGIN_EXPIRE);
        }
        return true;
    }
}
