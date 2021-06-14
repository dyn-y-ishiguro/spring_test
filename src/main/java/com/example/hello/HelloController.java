package com.example.hello;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/")
	public String hello(Model model, HttpServletRequest request) {
		String hotelCode = request.getParameter("hotelCode");
		LogUtils.error("hotelCode: " + hotelCode);
		TranslationProject tl = TranslationProject.getTranslationProject(hotelCode);
		LogUtils.error("tl.supportLanguage: " + Arrays.toString(tl.supportLanguage.toArray()));
		Map<String,String> supportLanguageMap = new HashMap<>();
		supportLanguageMap.put("ja", "日本語");
		for(String sl : tl.supportLanguage){
			if ("en".equals(sl)) {
				supportLanguageMap.put("en", "English");
			}
			else if ("zh-CN".equals(sl)) {
				supportLanguageMap.put("zh-CN", "简体中文");
			}
			else if ("zh-TW".equals(sl)) {
				supportLanguageMap.put("zh-TW", "繁體中文");
			}
			else if ("ko".equals(sl)) {
				supportLanguageMap.put("ko", "한국어");
			}
		}

		model.addAttribute("message", "Hello Thymeleaf!!");
		model.addAttribute("name", "taro");
		model.addAttribute("supportLanguageMap", supportLanguageMap);
		return "hello";
	}

	@GetMapping("/link")
	public String link(Model model) {
		return "link";
	}
}
