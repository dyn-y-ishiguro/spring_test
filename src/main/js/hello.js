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

// for vue
var component = {
  data: function(){
    return {
      'count': 0,
    };
  },
  template: '<div><div>{{ $t("click") }}: </div><div>{{count}}</div><button @click="increment">+1</button><input v-bind:placeholder="$t(\'click\')"></input></div>',
  methods: {
    increment: function(){
      this.count += 1;
    },
  },
};

window.vm = new Vue({
  el: '#vue',
  data: {
    message: "",
  },
  components: {
    "component-test": component,
  },
  i18n: i18n,
});
