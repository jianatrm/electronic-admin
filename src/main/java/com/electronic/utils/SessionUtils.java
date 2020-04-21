package com.electronic.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.electronic.base.model.SessionUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class SessionUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger(SessionUtils.class);

    public static SessionUser getSessionUser() throws UnsupportedEncodingException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SessionUser sessionUser = null;//new SessionUser(null,null,null,null,null,null,null,null);
        if (authentication != null) {
            if (authentication instanceof AnonymousAuthenticationToken) {
                return null;
            }
            OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) authentication.getDetails();
            String tokenValue = oAuth2AuthenticationDetails.getTokenValue();
            Claims claims = Jwts.parser().setSigningKey("jiana".getBytes("utf-8")).parseClaimsJws(tokenValue).getBody();
            String user = JSONObject.toJSONString(claims.get("user"));
            JSONObject parseObject = JSONObject.parseObject(user);
            Collection authorities = JSONObject.parseObject(parseObject.get("authorities").toString(), Collection.class);
            List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
            String userId = String.valueOf(parseObject.get("userId"));
            String userPhone = String.valueOf(parseObject.get("userPhone"));
            String userEmail = String.valueOf(parseObject.get("userEmail"));
            String userSex = String.valueOf(parseObject.get("userSex"));
            String deptId = String.valueOf(parseObject.get("deptId"));
            String username = String.valueOf(parseObject.get("username"));
            sessionUser = new SessionUser(Integer.parseInt(userId),userPhone,userEmail, userSex, Integer.parseInt(deptId),username,"null",list );
           // BeanUtils.copyProperties(parseObject,sessionUser);
            return sessionUser;
        }

        return sessionUser;
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbImFsbCJdLCJhdGkiOiJiNjViMjE3OC1iZGMwLTQ2NmUtODUxNi04OTEyZDEzZjQ5ZjEiLCJleHAiOjE1OTAwMjU5NDQsInVzZXIiOnsicGFzc3dvcmQiOm51bGwsInVzZXJuYW1lIjoiYWRtaW4iLCJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9XSwiYWNjb3VudE5vbkV4cGlyZWQiOnRydWUsImFjY291bnROb25Mb2NrZWQiOnRydWUsImNyZWRlbnRpYWxzTm9uRXhwaXJlZCI6dHJ1ZSwiZW5hYmxlZCI6dHJ1ZSwidXNlclBob25lIjoiYWRtaW4iLCJ1c2VyRW1haWwiOiJhZG1pbiIsInVzZXJTZXgiOiIxIiwidXNlcmlkIjoxfSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiJkNWViYmIyOS05ZDBjLTQ4OGYtODFjYi1mYzJkZmJkOWZkYjQiLCJjbGllbnRfaWQiOiJqaWFuYSJ9.kDthkU26-jCvRMbmBNf0HL3jaa0FDZS-dGzrGLNzJs0";
        Claims claims = Jwts.parser().setSigningKey("jiana".getBytes("utf-8")).parseClaimsJws(token).getBody();
        System.out.println(claims);
    }
}
