import './common.js';
import Vue from 'vue';
import i18next from 'i18next';

function hello1() {
  console.log(i18next.t("おはよう!"));
};
document.getElementById("hello1").onclick = function() {
  hello1();
};

function hello2() {
  console.log(i18next.t("こんにちは!"));
};
window.hello2 = hello2;

window.hello3 = function() {
  console.log(i18next.t("こんばんは!"));
};

function GetCookie(name) {
  var result = null;

  var cookieName = name + '=';
  var allcookies = document.cookie;

  var position = allcookies.indexOf(cookieName);
  if(position != -1) {
    var startIndex = position + cookieName.length;

    var endIndex = allcookies.indexOf(';', startIndex);
    if(endIndex == -1) {
      endIndex = allcookies.length;
    }

    result = decodeURIComponent(allcookies.substring(startIndex, endIndex));
  }

  return result;
}

// for i18next
window.i18next = i18next;

var en_dic = {
  'おはよう!': 'good morning',
  'こんにちは!': 'hello',
  'こんばんは!': 'good evening',
  'ハロー、VueJS!': 'Hello VueJS!',
  'クリック回数': 'click count',
};

var ja_dic = {
  'おはよう!': 'おはよう!',
  'こんにちは!': 'こんにちは!',
  'こんばんは!': 'こんばんは!',
  'ハロー、VueJS!': 'ハロー、VueJS!',
  'クリック回数': 'クリック回数',
};

i18next.init(
  {
    fallbackLng: 'en',
    resources: {}
  }
);
i18next.addResources('en', 'translation', en_dic);
i18next.addResources('ja', 'translation', ja_dic);
i18next.changeLanguage(GetCookie('locale'));

// for vue
var component = {
  data: function(){
    return {
      'click': i18next.t('クリック回数'),
      'count': 0,
    };
  },
  template: "<p>{{click}}: {{count}}<button @click='increment'>+1</button></p>",
  methods: {
    increment: function(){
      this.count += 1;
    },
  },
};

window.vm = new Vue({
  el: '#vue',
  data: {
    hello: i18next.t('ハロー、VueJS!'),
    color: {
      apple: i18next.t('red'),
      banana: i18next.t('yellow'),
      melon: i18next.t('green'),
    },
    number: [i18next.t('zero'), i18next.t('one'), i18next.t('two'), i18next.t('three')],
    message: "",
  },
  components: {
    "component-test": component,
  },
});
