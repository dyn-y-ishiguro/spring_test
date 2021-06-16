package com.example.hello;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

// DBから取得した言語情報をもとに、利用可能言語の情報を組み立ててaddAttributeする
// 共通Utilとして置くことを想定
public class I18nUtils {
	public static void getSupportLanguage(Model model, HttpServletRequest request) {
		String hotelCode = request.getParameter("hotelCode");
		TranslationProject tl = TranslationProject.getTranslationProject(hotelCode);
		Map<String,String> supportLanguageMap = new HashMap<>();
		supportLanguageMap.put("ja", "日本語");
		for(String sl : tl.supportLanguage){
			if ("en".equals(sl)) {
				supportLanguageMap.put("en", "English");
			}
			else if ("zh_CN".equals(sl)) {
				supportLanguageMap.put("zh_CN", "简体中文");
			}
			else if ("zh_TW".equals(sl)) {
				supportLanguageMap.put("zh_TW", "繁體中文");
			}
			else if ("ko".equals(sl)) {
				supportLanguageMap.put("ko", "한국어");
			}
		}

		model.addAttribute("supportLanguageMap", supportLanguageMap);
	}
}
