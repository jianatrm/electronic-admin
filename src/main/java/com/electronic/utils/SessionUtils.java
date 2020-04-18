package com.electronic.utils;

import com.electronic.base.model.SessionUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SessionUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger(SessionUtils.class);

    public static SessionUser getSessionUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SessionUser sessionUser = new SessionUser();
        if (authentication != null) {
            if (authentication instanceof AnonymousAuthenticationToken) {
                return null;
            }

            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
            Set<String> roles = new HashSet<>();
            while (iterator.hasNext()){
                String authority = iterator.next().getAuthority();
                roles.add(authority);
            }
            sessionUser.setUsername(authentication.getPrincipal()+"");
            sessionUser.setRoles(roles);
           /*
            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                Object principal = authentication.getPrincipal();
                return (SessionUser) authentication.getPrincipal();
            }*/
        }

       return sessionUser;
    }

}
