import './common.js';

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
