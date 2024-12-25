
let x:number=30
let y: number = 27
let temp:number;
console.log(`Value before the change x=${x} and y=${y}`);

temp=x;
x=y;
y=temp;
console.log(`Value after the change x=${x} and y=${temp}`);