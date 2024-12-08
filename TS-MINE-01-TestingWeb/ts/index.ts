import {mealList} from './BD';

const cmbMeal=document.getElementById('cmbMeal') as HTMLSelectElement;
const cmbAditional=document.getElementById('cmbAditional');
const txtPrice=document.getElementById('txtPrice');
const txtIva=document.getElementById('txtIva');
const txtSubtotal=document.getElementById('txtSubtotal');
const txtTotal=document.getElementById('txtTotal');
const btnCalc=document.getElementById('btnCalc');
const btnClean=document.getElementById('btnClean');

window.addEventListener('DOMContentLoaded',()=>{
    mealList.forEach((meal)=>{
        let option=document.createElement('option') as HTMLOptionElement;
        option.value=String(meal.id);
        option.textContent=meal.name;

        cmbMeal.appendChild(option);
    });
});

