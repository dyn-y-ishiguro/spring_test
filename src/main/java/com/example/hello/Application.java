package com.example.hello;

import java.util.Locale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@SpringBootApplication
public class Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	// 言語解決の方法を指定するために追加
	// 記述がない場合は、デフォルトでAcceptHeaderLocaleResolverが用いられる
	// 今回cookieの値をもとに解決したいためCookieLocaleResolverを使うが、
	// 施設によっては多言語機能を利用しない場合があるので
	// CookieResolverを継承して制約を加えたものを使う
	@Bean
	public LocaleResolver localeResolver() {
		MyCookieLocaleResolver myCookieLocaleResolver = new MyCookieLocaleResolver();
		myCookieLocaleResolver.setCookieName("locale");
		myCookieLocaleResolver.setDefaultLocale(Locale.JAPANESE);
		return myCookieLocaleResolver;
	}

	// クエリで指定した言語を利用するために追加
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}

	// クエリで指定した言語を利用するために追加
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

}
