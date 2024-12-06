"use strict";
let muerteDinosarios = 76_000_00;
let dinoFavorito = 'T-Rex';
let extintos = true;
console.log(muerteDinosarios + ' ' + dinoFavorito + ' ' + extintos);
let animal = ['perro', 'gato', 'caballo', 'tigre'];
let number = [1, 2, 3, 4, 5, 6, 7, 8, 9];
let check = [true, false, true, true];
let numberTwo = [1, 2, 4, 5, 9, 74];
let tupla = [1, ['Hoal', 'Mundo', 'XD']];
const pequenia = 's';
const mediana = 'm';
const grande = 'l';
const supergrande = 'xl';
var talla;
(function (talla) {
    talla[talla["pequenia"] = 1] = "pequenia";
    talla[talla["mediana"] = 2] = "mediana";
    talla[talla["grande"] = 3] = "grande";
    talla[talla["supergrande"] = 4] = "supergrande";
})(talla || (talla = {}));
let tallaElegida = talla.pequenia;
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
const objetc = {
    id: 1,
    name: 'Juan',
};
objetc.name = 'Pedro';
//# sourceMappingURL=index.js.map