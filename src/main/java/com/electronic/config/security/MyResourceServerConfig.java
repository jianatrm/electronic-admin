/**
 *
 */
package com.electronic.config.security;

import com.electronic.config.security.config.FormAuthenticationConfig;
import com.electronic.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * 资源服务器配置
 *
 * @author zhailiang
 *
 */
@Configuration
@EnableResourceServer
public class MyResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private LogoutSuccessHandler logoutSuccessHandler;

	@Autowired
	private FormAuthenticationConfig formAuthenticationConfig;

	@Override
	public void configure(HttpSecurity http) throws Exception {

		formAuthenticationConfig.configure(http);

		http
				.logout()
				.logoutSuccessHandler(logoutSuccessHandler)
				.deleteCookies("JSESSIONID").and()
				.authorizeRequests()
				.antMatchers("/file/**","/dist/**","/pdf/**")
				.permitAll().anyRequest().authenticated().and()
				.csrf().disable();


	}

}
