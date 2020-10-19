package cn.codewoo.config;

import cn.codewoo.shiro.CustomAccessControlFilter;
import cn.codewoo.shiro.CustomHashCredentialMatcher;
import cn.codewoo.shiro.CustomRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author kehong
 * shiro配置类
 */
@Configuration
public class ShiroConfig {
    @Bean
    public CustomHashCredentialMatcher credentialsMatcher(){
        return new CustomHashCredentialMatcher();
    }

    @Autowired
    @Bean
    public CustomRealm realm(HashedCredentialsMatcher credentialsMatcher){
        CustomRealm realm = new CustomRealm();
        realm.setCredentialsMatcher(credentialsMatcher);
        return realm;
    }

    @Autowired
    @Bean
    public SecurityManager securityManager(AuthorizingRealm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Autowired
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactory(SecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        LinkedHashMap<String, Filter> filters = new LinkedHashMap<>();
        filters.put("token",new CustomAccessControlFilter());
        bean.setFilters(filters);
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("/api/v1/pri/user/register", "anon");
        linkedHashMap.put("/api/v1/pri/user/login", "anon");
        linkedHashMap.put("/api/v1/pri/**", "token");
        bean.setFilterChainDefinitionMap(linkedHashMap);
        return bean;
    }
}
