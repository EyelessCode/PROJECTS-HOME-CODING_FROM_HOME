import {mealList} from './BD.js';

const cmbMeal=document.getElementById('cmbMeal');
const cmbAditional=document.getElementById('cmbAditional');
const txtPrice=document.getElementById('txtPrice');
const txtIva=document.getElementById('txtIva');
const txtSubtotal=document.getElementById('txtSubtotal');
const txtTotal=document.getElementById('txtTotal');
const btnCalc=document.getElementById('btnCalc');
const btnClean=document.getElementById('btnClean');

window.addEventListener('DOMContentLoaded',()=>{
    mealList.forEach((meal)=>{
        let option=document.createElement('option');
        option.value=String(meal.id);
        option.textContent=meal.name;

        cmbMeal.appendChild(option);
    });
});
