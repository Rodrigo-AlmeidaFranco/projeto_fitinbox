package br.fitinbox.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.fitinbox.demo.interceptor.Interceptor;


@Configuration
public class AppConfig implements WebMvcConfigurer{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new Interceptor()).addPathPatterns("/**")
				.excludePathPatterns("login", "/", "/fazerLogin");
	}
}
