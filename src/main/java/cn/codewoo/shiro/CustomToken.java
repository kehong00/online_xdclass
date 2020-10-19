package cn.codewoo.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author kehong
 * 自定义token
 */
public class CustomToken extends UsernamePasswordToken {
    private String token;

    public CustomToken() {
    }

    public CustomToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }
}
