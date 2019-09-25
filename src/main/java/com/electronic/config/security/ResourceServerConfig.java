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
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 资源服务器配置
 * 
 * @author zhailiang
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Autowired
	protected AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

	@Autowired
	private FormAuthenticationConfig formAuthenticationConfig;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		formAuthenticationConfig.configure(http);
		
		http
				.authorizeRequests()
				.antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
						SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE,
						"/oauth/token"
				).permitAll().anyRequest().authenticated().and()
							.logout()   //退出登录相关配置
		                    //.logoutUrl("logout")   //自定义退出登录页面
		                  	//.logoutSuccessHandler() //退出成功后要做的操作（如记录日志），和logoutSuccessUrl互斥
		                   	//.logoutSuccessUrl("/index") //退出成功后跳转的页面
		                    .deleteCookies("JSESSIONID").and()
				.csrf().disable();
		

	}
	
}