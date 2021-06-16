package com.example.hello;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
// プラン一覧等のコントローラを想定したサンプル
// addAttributeで利用可能言語の情報を渡してあげる必要がある(I18Utils.getSupportLanguage)
	@GetMapping("/")
	public String hello(Model model, HttpServletRequest request) {
		I18nUtils.getSupportLanguage(model, request);
		model.addAttribute("message", "Hello Thymeleaf!!");
		model.addAttribute("name", "taro");
		return "hello";
	}

// 検証用
	@GetMapping("/link")
	public String link(Model model) {
		return "link";
	}
}
