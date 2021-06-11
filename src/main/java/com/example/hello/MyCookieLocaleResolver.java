package com.example.hello;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

public class MyCookieLocaleResolver extends CookieLocaleResolver {
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		LogUtils.error("in MyCookieLocaleResolver.resolveLocale()");
		return super.resolveLocale(request);
	}
}
