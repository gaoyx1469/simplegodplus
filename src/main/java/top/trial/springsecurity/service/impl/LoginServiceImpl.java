package top.trial.springsecurity.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.trial.springsecurity.service.LoginService;

/**
 * @Author gaoyx1469
 * @Date 2020/8/6
 * @Version 1.0
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
