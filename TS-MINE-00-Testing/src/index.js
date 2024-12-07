/* console.log('HELLO WORLD');
let menssage:String="Hoal";

console.log(menssage); */
/* Es increíble que se pueda usar el guión bajo para hacer que
el número sea más reconocible. */
var muerteDinosarios = 7600000;
var dinoFavorito = 'T-Rex';
var extintos = true;
console.log(muerteDinosarios + ' ' + dinoFavorito + ' ' + extintos);
/* function math(precio:number,interesEntrada:number):number {
    precio=80_000_000;
    interesEntrada=0.20;
    let total:number=precio*interesEntrada;
    console.log('Saldo: '+total)
    return total;
}


function iva(math:number,iva:number):number {
    iva=0.15;
    math=69_582_748
    let total:number=math*iva;
    console.log('Total: '+total)
    return total;
}

console.log('Saldo: '+math+' Total: '+iva) */
var animal = ['perro', 'gato', 'caballo', 'tigre'];
var number = [1, 2, 3, 4, 5, 6, 7, 8, 9];
var check = [true, false, true, true];
var numberTwo = [1, 2, 4, 5, 9, 74];
/* La 'Tupla' es algo exraña, es una array de un array
O eso entiendo... */
var tupla = [1, ['Hoal', 'Mundo', 'XD']];
/* El 'enum' (tipo enumerado) eirve para establecer */
var pequenia = 's';
var mediana = 'm';
var grande = 'l';
var supergrande = 'xl';
/* Va como un 'index' el 'pequenia' es valor 0; pero,
si le asignamos un valor, en este caso '1'
los demás contarán por defecto */
var talla;
(function (talla) {
    talla[talla["pequenia"] = 1] = "pequenia";
    /* Si asignamos como 'string' a cada variable o dato del
    enum, debemos hacerlo con el resto también. */
    talla[talla["mediana"] = 2] = "mediana";
    talla[talla["grande"] = 3] = "grande";
    talla[talla["supergrande"] = 4] = "supergrande";
})(talla || (talla = {}));
var tallaElegida = talla.pequenia;
if (tallaElegida == 1) {
    console.log(tallaElegida + ' La talla es pequenia');
}
else {
    console.log('La talla no es pequenia');
}
var Color;
(function (Color) {
    Color[Color["ROJO"] = 0] = "ROJO";
    Color[Color["AZUL"] = 1] = "AZUL";
    Color[Color["VERDE"] = 2] = "VERDE";
})(Color || (Color = {}));
;
/* Podemos cear objetos y asignarles tipos de datos de
forma explícita. Cuando una propiedad tiene un '?'
(signo de interrogación) es porque es opcional */
var objetc = {
    id: 1,
    name: 'Juan',
    // age:30
    tallas: talla.supergrande
};
/* También puedes cambiarle los valores de las propiedades.
Algo que se puede hacer en TS y JS, pero lo que no se puede
hacer en TS pero si es JS es agregarle una nueva propiedad. */
objetc.name = 'Pedro';
var objetc2Value = {
    id: 1,
    names: 'Juan',
    age: 30,
    tallas: talla.pequenia,
    addres: {
        street: 'Falcón',
        number: 7,
        country: 'Holanda'
    },
    /* Objeto agregado por objeto agregado por objeto. */
    adressTwo: {
        street: 'Falcón',
        city: 'Holanda',
        country: 'Holanda'
    }
};
var student = [
    { id: 1, name: 'Juan', lastname: 'Pérez' },
    { id: 2, name: 'Juan', lastname: 'Pérez' },
    { id: 3, name: 'Juan', lastname: 'Pérez' },
];
