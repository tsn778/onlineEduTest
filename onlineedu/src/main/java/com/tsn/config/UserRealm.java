package com.tsn.config;

import com.tsn.pojo.User;
import com.tsn.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

//自定义UserRealm
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("执行了=>授权doGetAuthorizationInfo");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //拿到当前登录对象
        Subject subject= SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();
//         info.addStringPermission("user:add");
        //设置当前用户权限
        if("admin".equals(currentUser.getRole())) {


            info.addRole("admin");
            info.addStringPermission("look");//查看
            info.addStringPermission("senior");//可以进入后台

            info.addStringPermission("manageall");//管理所有
            info.addStringPermission("examine");//审核


        }else if("editor".equals(currentUser.getRole())) {


            info.addRole("editor");
            info.addStringPermission("look");//查看
            info.addStringPermission("senior");//可以进入后台
            info.addStringPermission("write");//编写
            info.addStringPermission("manageuser");//管理用户
            info.addStringPermission("examine");//审核

        }else if("user".equals(currentUser.getRole())) {


            info.addRole("user");
            info.addStringPermission("look");//查看


        }
        return info;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        System.out.println("执行了=>认证doGetAuthorizationInfo");



        UsernamePasswordToken userToken=(UsernamePasswordToken)authenticationToken;

        User user = userService.getUserByAccount(userToken.getUsername());

        if(user==null)
        {

            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
