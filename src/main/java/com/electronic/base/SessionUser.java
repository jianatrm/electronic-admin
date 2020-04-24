package com.electronic.base;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class SessionUser extends User {

    private final Integer userId;

    private final String userPhone;

    private final String userEmail;

    private final String userSex;

    private final Integer deptId;




    public SessionUser(Integer userId,String userPhone,String userEmail,String userSex,Integer deptId,String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userId = userId;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userSex = userSex;
        this.deptId = deptId;

    }

    public Integer getUserid() {
        return userId;
    }


    public String getUserPhone() {
        return userPhone;
    }


    public String getUserEmail() {
        return userEmail;
    }


    public String getUserSex() {
        return userSex;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getDeptId() {
        return deptId;
    }
}
