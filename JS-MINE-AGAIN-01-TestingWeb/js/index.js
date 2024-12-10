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

/* cmbMeal.addEventListener('change',()=>{
    alert(`se está ejecunado...`);
    let i=cmbMeal.selectedIndex;
    let code=cmbMeal.options[i].value;
    let mealSelection=mealList.find((meal)=>meal.id===parseInt(code));


    txtPrice.value=parseFloat(mealSelection.price);
}); */

// const mealCombo=
cmbMeal.addEventListener('change',()=>{
    let i=cmbMeal.selectedIndex;
    let code=cmbMeal.options[i].value;
    let mealSelection=mealList.find((meal)=>meal.id===parseInt(code));
    let iva=ivaEnter(mealSelection.price).toFixed(2);
    
    txtIva.value=parseFloat(iva).toFixed(2);
    txtPrice.value=parseFloat(mealSelection.price).toFixed(2);
    // alert(`se está ejecunado...`);
});

// const buttonCalc=
btnCalc.addEventListener('click',()=>{
    // console.log(`hoal`)
/*     let i=cmbMeal.selectedIndex;
    let code=cmbMeal.options[i].value;
    let mealSelection=mealList.find((meal)=>meal.id===parseInt(code)); */
    
    // let price=parseFloat(mealSelection.price).toFixed(2);
    let price=Number(txtPrice.value);
    if (price!==0) {
        let ivaa=Number(txtIva.value);
        // let iva=ivaEnter(price).toFixed(2);
        let subtotal=Number(subtotalEnter(price,ivaa));
        let total=Number(totalEnter(subtotal,ivaa));
    
        txtPrice.value=price;
        txtIva.value=Number(ivaa);
        txtSubtotal.value=parseFloat(subtotal).toFixed(2);
        txtTotal.value=parseFloat(total).toFixed(2);
        // console.log(`El precio: ${price} el iva: ${ivaa} el subtotal: ${subtotal} el total: ${total}`);

        if(subtotal!==0){
            cmbAditional.addEventListener('change',()=>{
            })
        }
    }else{
        alert(`Select a meal to calculate the total price`);
    }
});



/* txtPrice.addEventListener('input',()=>{
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

}); */

btnClean.addEventListener('click',()=>{
    cmbMeal.value='';
    cmbAditional.value='';
    txtPrice.value='';
    txtIva.value='';
    txtSubtotal.value='';
    txtTotal.value='';
})
