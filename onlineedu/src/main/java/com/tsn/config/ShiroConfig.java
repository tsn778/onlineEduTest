package com.tsn.config;


import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        Map<String,String> filterMap=new LinkedHashMap<>();
        //添加shiro的内置过滤器
           /*
                anon:无需认证就可以访问
                authc: 必须认证了才能访问
                user: 必须拥有 记住我 功能才能用
                perms: 拥有对某个资源的权限才能访问
                role：拥有某个角色权限才能访问
            */
        filterMap.put("/admin/*","perms[senior]");
        filterMap.put("/personal","perms[look]");

        bean.setFilterChainDefinitionMap(filterMap);
        //设置登录请求
        bean.setLoginUrl("/login");
        bean.setUnauthorizedUrl("/noauth");

        return bean;

    }

    @Bean(name="securityManager")
    public DefaultWebSecurityManager getdefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;

    }




    //创建realm对象，自定义类
    @Bean
    public  UserRealm userRealm(){
        return new UserRealm();
    }

}
