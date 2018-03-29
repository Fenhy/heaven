package com.heaventony.shiro.security;

import com.heaventony.security.entity.User;
import com.heaventony.security.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/8/17
 * Time: 下午6:10
 */
public class HeavenShiroRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(HeavenShiroRealm.class);

    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证回调函数,登录时调用
     * 首先根据传入的用户名获取User信息；然后如果user为空，那么抛出没找到帐号异常UnknownAccountException；
     * 如果user找到但锁定了抛出锁定异常LockedAccountException；最后生成AuthenticationInfo信息，
     * 交给间接父类AuthenticatingRealm使用CredentialsMatcher进行判断密码是否匹配，
     * 如果不匹配将抛出密码错误异常IncorrectCredentialsException；
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String loginName = (String)authenticationToken.getPrincipal();
        logger.info(loginName + "开始登陆验证...");
        User user = userService.selectByName(loginName);
        authenticationToken.getCredentials();
        if (user == null) {
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getLoginName(),
                user.getPassword(),
                getName()
        );
        return authenticationInfo;
    }
}
