/* console.log('HELLO WORLD');
let menssage:String="Hoal";

console.log(menssage); */

/* Es increíble que se pueda usar el guión bajo para hacer que
el número sea más reconocible. */
let muerteDinosarios:number=76_000_00;
let dinoFavorito:String='T-Rex';
let extintos:boolean=true;

console.log(muerteDinosarios+' '+dinoFavorito+' '+extintos);

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

let animal:String[]=['perro','gato','caballo','tigre']
let number:number[]=[1,2,3,4,5,6,7,8,9]
let check:boolean[]=[true,false,true,true]
let numberTwo:Array<number>=[1,2,4,5,9,74]

/* La 'Tupla' es algo exraña, es una array de un array
O eso entiendo... */
let tupla:[number,String[]]=[1,['Hoal','Mundo','XD']]

/* El 'enum' (tipo enumerado) eirve para establecer */

const pequenia='s'
const mediana='m'
const grande='l'
const supergrande='xl'


/* Va como un 'index' el 'pequenia' es valor 0; pero,
si le asignamos un valor, en este caso '1'
los demás contarán por defecto */
enum talla{
    pequenia=1,
    /* Si asignamos como 'string' a cada variable o dato del
    enum, debemos hacerlo con el resto también. */
    mediana,
    grande,
    supergrande
}

let tallaElegida=talla.pequenia;

if(tallaElegida==1){
    console.log(tallaElegida+' La talla es pequenia')
}else{
    console.log('La talla no es pequenia')
}

enum Color {
    ROJO,
    AZUL,
    VERDE
};

/* Podemos cear objetos y asignarles tipos de datos de
forma explícita. Cuando una propiedad tiene un '?'
(signo de interrogación) es porque es opcional */
const objetc:{
    id:number,
    name:String,
    age?:number
}={
    id:1,
    name:'Juan',
    // age:30
}

/* También puedes cambiarle los valores de las propiedades.
Algo que se puede hacer en TS y JS, pero lo que no se puede
hacer en TS pero si es JS es agregarle una nueva propiedad. */
objetc.name='Pedro'