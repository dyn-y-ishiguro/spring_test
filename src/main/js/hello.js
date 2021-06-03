import './common.js';
import Vue from 'vue';
import i18next from 'i18next';
import LanguageDetector from 'i18next-browser-languagedetector';
import VueI18Next from '@panter/vue-i18next';

function hello1() {
  console.log(i18next.t("greet1"));
};
document.getElementById("hello1").onclick = function() {
  hello1();
};

function hello2() {
  console.log(i18next.t("greet2"));
};
window.hello2 = hello2;

window.hello3 = function() {
  console.log(i18next.t("greet3"));
};

// for i18next
//window.i18next = i18next;

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
const i18n = new VueI18Next(i18next);

// for vue
var component = {
  data: function(){
    return {
      'count': 0,
    };
  },
  template: "<div><div>{{ $t('click') }}: </div><div>{{count}}</div><button @click='increment'>+1</button></div>",
  methods: {
    increment: function(){
      this.count += 1;
    },
  },
};

window.vm = new Vue({
  el: '#vue',
  data: {
    hello: 'helloVue',
    color: {
      apple: 'red',
      banana: 'yellow',
      melon: 'green',
    },
    number: ['zero', 'one', 'two', 'three'],
    message: "",
  },
  components: {
    "component-test": component,
  },
  i18n: i18n,
});
