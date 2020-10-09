package top.trial.springsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.trial.springsecurity.dao.UserInfoDao;
import top.trial.springsecurity.domain.RoleDomain;
import top.trial.springsecurity.domain.UserDomain;
import top.trial.springsecurity.service.LoginService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author gaoyx1469
 * @Date 2020/8/6
 * @Version 1.0
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserInfoDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDomain userDomain = dao.getUserByName(username);
        if (userDomain == null)
            throw new UsernameNotFoundException("用户不存在");
        String userStatus = userDomain.getStatus();
        boolean enabled = false;

        if ("1".equals(userStatus))
            enabled = true;

        return new User(userDomain.getName(), "{noop}" + userDomain.getPassword(), enabled, true, true, true, getAuthorities(userDomain.getRoles()));
    }

    private List<SimpleGrantedAuthority> getAuthorities(List<RoleDomain> roles) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (RoleDomain roleDomain : roles) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + roleDomain.getName());
            authorities.add(authority);
        }
        return authorities;
    }
}
