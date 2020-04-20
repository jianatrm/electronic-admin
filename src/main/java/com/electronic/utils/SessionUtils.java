package com.electronic.utils;

import com.electronic.base.model.SessionUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.io.UnsupportedEncodingException;


public class SessionUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger(SessionUtils.class);

    public static SessionUser getSessionUser() throws UnsupportedEncodingException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SessionUser sessionUser = null;
        if (authentication != null) {
            if (authentication instanceof AnonymousAuthenticationToken) {
                return null;
            }
            OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) authentication.getDetails();
            String tokenValue = oAuth2AuthenticationDetails.getTokenValue().replace("[", "");
              Claims claims = Jwts.parser().setSigningKey("jiana".getBytes("utf-8")).parseClaimsJws(tokenValue).getBody();
            System.out.println();
        }


        return sessionUser;
    }

}
