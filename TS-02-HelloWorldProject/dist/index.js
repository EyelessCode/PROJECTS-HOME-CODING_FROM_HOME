"use strict";
class Greeter {
    greeting;
    constructor(message) {
        this.greeting = message;
    }
    greet() {
        return 'Hello ' + this.greeting;
    }
}
let greeter = new Greeter('World');
let button = document.createElement('button');
button.textContent = 'Say Hello';
button.onclick = function () {
    alert(greeter.greet());
};
document.body.appendChild(button);
var foo = 123;
if (true) {
    var foo = 456;
}
console.log(foo);
let oof = 123;
if (true) {
    let oof = 456;
}
console.log(oof);
var fof = 123;
function test() {
    var fof = 456;
}
test();
console.log(fof);
let fullName = 'Carlos Serrano';
console.log(fullName.charAt(1));
console.log(fullName.charCodeAt(1));
console.log(fullName.concat(' says Hi!'));
console.log(fullName.indexOf('a') + ' & ' + fullName.indexOf('z'));
console.log(fullName.lastIndexOf('o'));
console.log(fullName.slice(0, 3) + ', but -> ' + fullName.slice(3, -2));
console.log(fullName.split(' '));
console.log(fullName.substr(0, 3) + ', but -> ' + fullName.substr(-2, 6));
console.log(fullName.toUpperCase());
console.log(fullName.toLowerCase());
var Color;
(function (Color) {
    Color[Color["Red"] = 1] = "Red";
    Color[Color["Green"] = 2] = "Green";
    Color[Color["Blue"] = 4] = "Blue";
})(Color || (Color = {}));
;
let c = Color.Green;
let colorName = Color[4];
console.log(c);
console.log(colorName);
let list1 = [1, 2, 3];
let list2 = [1, 2, 3];
let list3 = new Array(3);
let list5 = new Array(4, 5, 6);
let list4 = new Array(1, 2, 3);
for (let i = 0; i < list1.length; i++) {
    console.log(list1[i]);
}
console.log(list3.length);
console.log(list3[0]);
for (let x in list4) {
    console.log(x);
}
for (let y of list4) {
    console.log(y);
}
//# sourceMappingURL=index.js.map