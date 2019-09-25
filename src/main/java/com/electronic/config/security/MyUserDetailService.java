package com.electronic.config.security;

import com.electronic.dao.mapper.bo.SysUser;
import com.electronic.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailService implements UserDetailsService {
    private static  final Logger LOGGER = LoggerFactory.getLogger(MyUserDetailService.class);

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = new SysUser();
        user.setUsername(username);
        SysUser sysUser = null;
        try {
            sysUser = sysUserService.selectSysUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("获取用户失败 {} {}", e.getMessage());
        }
        if (sysUser == null) throw new UsernameNotFoundException("Username " + username + " not found");
        return new User(sysUser.getUsername(),sysUser.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));

    }
}
