import Vue from 'vue';
import i18next from 'i18next';
import LanguageDetector from 'i18next-browser-languagedetector';
import VueI18Next from '@panter/vue-i18next';

// for i18next
window.Vue = Vue;
window.i18next = i18next;
window.LanguageDetector = LanguageDetector;
window.VueI18Next = VueI18Next;

const languageDetectorOption = {
  order: ['querystring', 'cookie', 'navigator'],
  lookupQuerystring: 'lang',
  lookupCookie: 'locale',
  caches: [],
};

i18next.use(LanguageDetector).init(
  {
    fallbackLng: 'ja',
    resources: {
      ja: {'translation': ja_dic},
      en: {'translation': en_dic},
    },
    detection: languageDetectorOption,
  }
);

Vue.use(VueI18Next);
window.i18n = new VueI18Next(i18next);
