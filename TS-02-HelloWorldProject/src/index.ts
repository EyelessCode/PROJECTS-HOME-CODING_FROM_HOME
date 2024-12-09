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