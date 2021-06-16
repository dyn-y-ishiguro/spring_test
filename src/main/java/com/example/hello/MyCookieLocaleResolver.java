package com.example.hello;

import java.util.Locale;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

public class MyCookieLocaleResolver extends CookieLocaleResolver {

	// 言語解決ロジック
	// １.対象の施設で利用できる言語の設定を取得する
	// ２.クエリ指定の言語がある場合、１に含まれていればreturn、なければ日本語をreturn
	// ３.継承元のロジックで言語解決した場合の結果を取得し、１に含まれていればreturn、なければ日本語をreturn
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
