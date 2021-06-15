package com.example.hello;

import java.util.Locale;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

public class MyCookieLocaleResolver extends CookieLocaleResolver {
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String hotelCode = request.getParameter("hotelCode");
		TranslationProject tl = TranslationProject.getTranslationProject(hotelCode);
		List<String> supportLanguageList = tl.supportLanguage;

		String lang = request.getParameter("lang");
		if (lang != null && !tl.supportLanguage.contains(lang)) {
			return Locale.JAPAN;
		}

		Locale reqLocale = super.resolveLocale(request);
		if (!tl.supportLanguage.contains(reqLocale.toString())) {
			return Locale.JAPAN;
		}
//TODO 中国語周りのequal判定正しく
		return reqLocale;
	}
}
