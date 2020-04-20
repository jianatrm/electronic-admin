/**
 *
 */
package com.electronic.config.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author jiana
 *
 */
@Configuration
public class TokenStoreConfig {

	/*@Autowired
	private RedisConnectionFactory redisConnectionFactory;*/

	/*@Bean
	@ConditionalOnProperty(prefix = "com.security.oauth2", name = "tokenStore", havingValue = "redis")
	public TokenStore redisTokenStore() {
		return new RedisTokenStore(redisConnectionFactory);
	}*/



	@Configuration
//	@ConditionalOnProperty(prefix = "com.security.oauth2", name = "tokenStore", havingValue = "jwt", matchIfMissing = true)
	public static class JwtConfig {

		/*@Autowired(required=true)
		private SecurityProperties securityProperties;*/

		@Bean
		public TokenStore jwtTokenStore() {
			return new JwtTokenStore(jwtAccessTokenConverter());
		}

		@Bean
		public JwtAccessTokenConverter jwtAccessTokenConverter(){
			JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
			converter.setSigningKey("jiana");
			converter.setAccessTokenConverter(new CustomerAccessTokenConverter());
			return converter;
		}
		@Bean
		@ConditionalOnBean(TokenEnhancer.class)
		public TokenEnhancer jwtTokenEnhancer(){
			return new CustomTokenEnhancer();
		}


	}



}
