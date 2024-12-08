import { mealList,aditionalOneLis,aditionalTwoList,aditionalThreeList } from './BD.js';
import {ivaEnter,subtotalEnter,totalEnter} from './math.js';

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
        option.value=meal.id;
        option.textContent=meal.name;

        cmbMeal.appendChild(option);
    });
});

cmbMeal.addEventListener('change',()=>{
    let i=cmbMeal.selectedIndex
    let code=cmbMeal.options[i].value
    let mealSelection=mealList.find((meal)=>meal.id===parseInt(code));

    let price=parseFloat(mealSelection.price).toFixed(2);
/*     let iva=parseFloat(price*0.15).toFixed(2);
    let subtotal=parseFloat(price+iva).toFixed(2);
    let total=parseFloat(subtotal+iva).toFixed(2); */
    let iva=ivaEnter(price);
    // let subtotal=subtotalEnter(price,iva);
    // let total=subtotal;
    txtPrice.value=parseFloat(price).toFixed(2);
    txtIva.value=parseFloat(iva).toFixed(2);
    // txtSubtotal.value=parseFloat(subtotal).toFixed(2);
    // txtTotal.value=parseFloat(total).toFixed(2);
});

txtPrice.addEventListener('input',()=>{
    let i=cmbMeal.selectedIndex
    let code=cmbMeal.options[i].value
    let mealSelection=mealList.find((meal)=>meal.id===parseInt(code));

    if (txtPrice.value>1) {
        btnCalc.disabled=false;
        alert('hoal')
        btnCalc.addEventListener('click',()=>{
            
        });
    }else{
        btnCalc.disabled=true;
    }

});

btnClean.addEventListener('click',()=>{
    cmbMeal.value='';
    cmbAditional.value='';
    txtPrice.value='';
    txtIva.value='';
    txtSubtotal.value='';
    txtTotal.value='';
})
