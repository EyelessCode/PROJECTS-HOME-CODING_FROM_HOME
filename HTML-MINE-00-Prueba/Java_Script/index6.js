var num=prompt("INGRESE EL PRIMER NÚMERO: ");
var num2=prompt("INGRESE EL SEGUNDO NÚMERO: ");

var resta=num-num2;

if (resta>0) {
    console.log("ES MAYOR A 0");
    let impar=resta%2;
    
    if (impar==0) {
        console.log("ES PAR");
        
    }else{
        console.log("ES IMPAR");
    }
} else {
    console.log("ES MENOR O IGUAL A 0");
    
}