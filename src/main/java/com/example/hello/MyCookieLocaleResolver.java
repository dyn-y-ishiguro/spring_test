package com.example.hello;

import java.util.Locale;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

public class MyCookieLocaleResolver extends CookieLocaleResolver {
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String hotelCode = request.getParameter("hotelCode");
		TranslationProject tl = TranslationProject.getTranslationProject(hotelCode);
		List<Locale> supportLanguageList = tl.supportLanguage
		                                     .stream()
		                                     .map(i -> (i+"__").split("_", -1))
		                                     .map(i -> new Locale(i[0], i[1]))
		                                     .collect(Collectors.toList());

		String lang = request.getParameter("lang");
		//LogUtils.error("supportLanguageList: " + Arrays.toString(supportLanguageList.toArray()));
		if (lang != null) {
			String[] langArr = (lang+"__").split("_", -1);
			Locale queryLocale = new Locale(langArr[0],langArr[1]);
			//LogUtils.error("queryLocale:locale  :" + queryLocale);
			//LogUtils.error("queryLocale:language:" + queryLocale.getLanguage());
			//LogUtils.error("queryLocale:country :" + queryLocale.getCountry());
			if (supportLanguageList.contains(queryLocale)) {
				return queryLocale;
			}
			else {
				return Locale.JAPANESE;
			}
		}

		Locale reqLocale = super.resolveLocale(request);
		//LogUtils.error("reqLocale:locale  :" + reqLocale);
		//LogUtils.error("reqLocale:language:" + reqLocale.getLanguage());
		//LogUtils.error("reqLocale:country :" + reqLocale.getCountry());
		if (!supportLanguageList.contains(reqLocale)) {
			return Locale.JAPANESE;
		}
		return reqLocale;
	}
}
