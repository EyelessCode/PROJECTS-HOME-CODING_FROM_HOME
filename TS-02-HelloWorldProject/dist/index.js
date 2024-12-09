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
let map = new Map([
    ['A', 1],
    ['B', 2],
    ['C', 3]
]);
map.get('A');
map.has('A');
map.delete('A');
console.log(map.size);
map.clear();
console.log(map.size);
let pam = new Map([
    ['ES', 1],
    ['EN', 2],
    ['IT', 3]
]);
for (let key of pam.keys()) {
    console.log(key);
}
for (let value of pam.values()) {
    console.log(value);
}
for (let entry of pam.entries()) {
    console.log(entry[0], entry[1]);
}
for (let [key, value] of pam.entries()) {
    console.log(key, value);
}
let set = new Set(['APPLE', 'ORANGE', 'MANGO']);
set.has('APPLE');
set.delete('APPLE');
set.size;
set.add('ORANGE');
console.log(set.size);
set.clear();
console.log(set.size);
let tes = new Set();
tes.add('APPLE');
tes.add('ORANGE');
tes.add('MANGO');
for (let entry of tes) {
    console.log(entry);
}
//# sourceMappingURL=index.js.map