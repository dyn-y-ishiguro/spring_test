import './common.js';
import Vue from 'vue';

function hello1() {
  console.log("hello1!");
};
document.getElementById("hello1").onclick = function() {
  hello1();
};

function hello2() {
  console.log("hello2!");
};
window.hello2 = hello2;

window.hello3 = function() {
  console.log("hello3!");
};

// for vue

var component = {
  data: function(){
    return {
      count: 0,
    };
  },
  template: "<p>クリック回数: {{count}}<button @click='increment'>+1</button></p>",
  methods: {
    increment: function(){
      this.count += 1;
    },
  },
};
var vm = new Vue({
  el: '#vue',
  data: {
    hello: 'Hello VueJS!',
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
});
window.vm = vm;
