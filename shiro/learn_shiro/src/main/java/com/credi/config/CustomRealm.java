package com.credi.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: He Xingchi
 * Created by Administrator on 2019/10/7.
 * 自定义的CustomRealm继承AuthorizingRealm。
 * 并且重写父类中的doGetAuthorizationInfo（权限相关）、doGetAuthenticationInfo（身份认证）这两个方法。
 */
public class CustomRealm extends AuthorizingRealm {
    /**
     * 身份认证
     * 这里可以注入userService,为了方便演示，我就写死了帐号了密码
     * private UserService userService;
     * <p>
     * 获取即将需要认证的信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-------身份认证方法--------");
//        获取UsernamePasswordToken中用户输入的用户名
        String userName = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        //根据用户名从数据库获取校验的用户信息
        String password = "123";
        if (userName == null) {
//            抛出对应的异常
            throw new AccountException("用户名不正确");
        } else if (!userPwd.equals(password )) {
            throw new AccountException("密码不正确");
        }
//  从数据库中查询的信息封装到 -> new SimpleAuthenticationInfo(userName, password,getName()) -> shiro框架进行信息的校验
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, password, getName());// getName() -> realm或自定义realm类名称
//            也可以吧查询到的用户信息存入 new SimpleAuthenticationInf(new User() , password , getName());
//        返回认证信息
        return simpleAuthenticationInfo;
    }

//    权限认证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("-------权限认证方法--------");
        //身份认证时 , 存入的信息可以被获取
        //        //获取用户名
//        User user = (User)SecurityUtils.getSubject().getPrincipal();
//        String username = (String) SecurityUtils.getSubject().getPrincipal();
        String username = (String) principals.getPrimaryPrincipal();
        //根据身份信息从数据库获取权限数据  == > 模拟
        List<String> permissions = new ArrayList<String>();
        permissions.add("admin");
        permissions.add("user:save");
        permissions.add("user:delete");
        permissions.add("userInfo:view");

//      将权限信息保存到shiro中的AuthorizationInfo中
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        list添加到AuthorizationInfo
        for(String permission:permissions){
            System.out.println(permission);
            info.addStringPermission(permission);
        }
//       set添加到AuthorizationInfo
//        Set<String> stringSet = new HashSet<>();
//        stringSet.add("user:show");
//        stringSet.add("user:admin");
//        info.setStringPermissions(stringSet);
        return info;
    }


}
