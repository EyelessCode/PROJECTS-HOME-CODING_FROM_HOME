import {mensual,interesCompuesto} from './logica.js';

const monto=document.getElementById('monto');
const tasaInteres=document.getElementById('tasaInteres');
const periodo=document.getElementById('periodo');
const calcular=document.getElementById('calcular');
const pagoMensual=document.getElementById('pagoMensual');
const interesTotal=document.getElementById('interesTotal');

calcular.addEventListener('click',()=>{
    let p=parseFloat(monto.value);
    let r=parseFloat(tasaInteres.value);
    let n=parseFloat(periodo.value);

    const pago=mensual(p,r,n);
    const interes=interesCompuesto(p,r,n);

    pagoMensual.textContent=pago.toFixed(2);
    interesTotal.textContent=interes.toFixed(2);
})