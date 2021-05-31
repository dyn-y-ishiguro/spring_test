import './common.js';
import Vue from 'vue';
import i18next from 'i18next';
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
//window.i18next = i18next;

i18next.init(
  {
    fallbackLng: 'ja',
    resources: {}
  }
);
i18next.addResources('ja', 'translation', ja_dic);
i18next.addResources('en', 'translation', en_dic);
i18next.changeLanguage(GetCookie('locale'));

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
