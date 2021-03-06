package com.bizideal.mn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * @author 作者 liulq:
 * @data 创建时间：2017年6月26日 下午2:25:49
 * @version 1.0
 * @description 描述
 */
@Configuration
// maxInactiveIntervalInSeconds session超时时间,单位秒
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 120)
public class RedisSessionConfig {

	// 配置实现二级域名情况下的跨域session共享
	// dns配置 C:\Windows\System32\drivers\etc
	// 127.0.0.1 a.msdx1.com
	// 10.1.0.18 b.msdx1.com
	// 不跨域或者只跨二级域名的情况下可以用spring session做session共享
	@Bean
	public CookieSerializer cookieSerializer() {
		DefaultCookieSerializer serializer = new DefaultCookieSerializer();
		serializer.setCookieName("JSESSIONID");
		serializer.setCookiePath("/");
		serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");
		return serializer;
	}
}
