class Greeter {
    greeting: string;
    constructor(message: string) {
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
}

document.body.appendChild(button);
var foo = 123;
if (true){
    var foo = 456;
}
console.log(foo); // 456

let oof = 123; //! It's having this
if (true) {
    let oof = 456;
}
console.log(oof); // 123

var fof = 123;
function test() {
    var fof = 456;
}
test();
console.log(fof); // 123

let fullName: string = 'Carlos Serrano';
console.log(fullName.charAt(1)); //devuelve el carácter de la posición

console.log(fullName.charCodeAt(1)); //el código del carácter de la posición

console.log(fullName.concat(' says Hi!')); //concatena cadenas

//da la posición de la primera aparición del carácter o -1 si no aparece
console.log(fullName.indexOf('a')+' & '+fullName.indexOf('z'));
console.log(fullName.lastIndexOf('o')); //última posición del carácter dado

/* realiza un corte en la cadena (inicio, fin). En caso de valor
negativo se empieza desde el final */
console.log(fullName.slice(0,3)+', but -> '+fullName.slice(3,-2));
/* trunca un string por el carácter dado y genera un Array con las
diferentes secciones*/
console.log(fullName.split(' '));
/*devuelve una subcadena (inicio, longitud), en caso negativo se
comienza por el final*/
console.log(fullName.substr(0,3)+', but -> '+fullName.substr(-2,6));
console.log(fullName.toUpperCase()); //Convierte en mayúscula
console.log(fullName.toLowerCase()); //Convierte en minúscula

enum Color {Red = 1, Green = 2, Blue = 4}; //value defined
let c: Color = Color.Green; //2
let colorName:string=Color[4]; //Blue
console.log(c); //2
console.log(colorName); //Blue

let list1: number[] = [1, 2, 3];
let list2: Array<number> = [1, 2, 3];
let list3: Array<number> = new Array(3); //only size defined
let list5: number[] = new Array(4,5,6) //size and values defined
let list4: Array<number> = new Array(1, 2, 3) //the same than list 5

//We can iterate an array with for statement
for (let i = 0; i < list1.length; i++){
    console.log(list1[i]);
}
console.log(list3.length); //it prints 3
console.log(list3[0]); //it prints undefined
/*Arrays implements Iterator interfaces. So we can use for-each statement.
We get keys with ‘in’*/
for (let x in list4) {
    console.log(x); //”0”, “1”, “2”
    } 
/*We get values with ‘of’*/ 
for (let y of list4) {
    console.log(y); // “1”, “2”, “3”
}

let map = new Map([
    [ 'A', 1 ],
    [ 'B', 2 ],
    [ 'C', 3 ]
]);

map.get('A'); //1
map.has('A'); //true
map.delete('A'); //true
console.log(map.size) //2 
map.clear();
console.log(map.size); //0

let pam = new Map([
    [ 'ES', 1 ],
    [ 'EN', 2 ],
    [ 'IT', 3 ]
]);
for (let key of pam.keys()) {
    console.log(key);
}
// ES
// EN 
// IT
for (let value of pam.values()) {
    console.log(value);
}
// 1
// 2
// 3
for (let entry of pam.entries()) {
    console.log(entry[0], entry[1]);
}
// “ES” 1
// “EN” 2
// “IT” 3
for (let [key, value] of pam.entries()) {
    console.log(key, value);
}
// “ES” 1
// “EN” 2
// “IT” 3

let set = new Set(['APPLE', 'ORANGE', 'MANGO']);
set.has('APPLE') // true
set.delete('APPLE')
set.size // 2
set.add('ORANGE');
//Orange already exits, so it isn’t added
//it returns the original Set, so you can check ‘size’
console.log(set.size) // 2
set.clear();
console.log(set.size) // 0

let tes = new Set();
tes.add('APPLE')
tes.add('ORANGE')
tes.add('MANGO');
//let tes:Set<String> = new Set() would be strongly typed
for (let entry of tes) {
    console.log(entry);
}
// APPLE
// ORANGE