package com.example.hello;

import java.util.List;
import java.util.ArrayList;

// 対象施設で利用できる言語情報取得のモック
// 本来はDBから取ってきたデータを利用する
// リクエスト毎に取得に行くので、cookieに２４時間キャッシュするなど必要？
public class TranslationProject {
	public String hotelCode;
	public List<String> supportLanguage;

	public static TranslationProject getTranslationProject(String hotelCode) {
		TranslationProject translationProject = new TranslationProject();

		List<String> sl = new ArrayList<>();
		if ("0000000001".equals(hotelCode)) {
			// 多言語未対応
		}
		else if ("0000000002".equals(hotelCode)) {
			// 多言語対応 英語のみ
			sl.add("en");
		}
		else if ("0000000003".equals(hotelCode)) {
			// 多言語対応 韓国語のみ
			sl.add("ko");
		}
		else if ("0000000004".equals(hotelCode)) {
			// 多言語対応 すべて
			sl.add("en");
			sl.add("zh_CN");
			sl.add("zh_TW");
			sl.add("ko");
		}

		translationProject.hotelCode = hotelCode;
		translationProject.supportLanguage = sl;

		return translationProject;
	}
}
