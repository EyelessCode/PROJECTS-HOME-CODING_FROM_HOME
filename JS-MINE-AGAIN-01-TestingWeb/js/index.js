import { mealList,aditionalOneList,aditionalTwoList,aditionalThreeList } from './BD.js';
import {aditionalIvaEnter,aditionalMealEnter,aditionalSubtotalEnter,aditionalTotalEnter,ivaEnter,subtotalEnter,totalEnter} from './math.js';
import {populateAditionalOptions,aditionalEvent} from './repository/aditionalRepository.js';
// import {populateAditionalOptions} from './repository/';

const cmbMeal=document.getElementById('cmbMeal');
const cmbAditional=document.getElementById('cmbAditional');
const txtPrice=document.getElementById('txtPrice');
const txtIva=document.getElementById('txtIva');
const txtAditional=document.getElementById('txtAditional');
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
    txtSubtotal.value='';
    txtTotal.value='';
    let i=cmbMeal.selectedIndex;
    let code=cmbMeal.options[i].value;

    let mealSelection=mealList.find((meal)=>meal.id===parseInt(code));
    // alert(`Índice: ${code} o ${mealSelection.id}`);

    let iva=ivaEnter(mealSelection.price);

    

    txtAditional.value='';
    // alert(`se está ejecunado...`);

    if (mealSelection) {
        txtIva.value=parseFloat(iva).toFixed(2);
        txtPrice.value=parseFloat(mealSelection.price).toFixed(2);

        switch (mealSelection.id) {
            case 1:
                populateAditionalOptions(aditionalOneList);
                aditionalEvent(mealSelection.id);
                break;
            case 2:
                populateAditionalOptions(aditionalTwoList);
                aditionalEvent(mealSelection.id);
                break;
            case 3:
                populateAditionalOptions(aditionalThreeList);
                aditionalEvent(mealSelection.id);
                break;
        }
    }
    
});



/* function insideOfAditionalEvent(list) {
    let selection=list.find((listNumber)=>listNumber.)
    let price=Number(txtPrice.value);
    let aditional=Number(selectAditional.priceAditional);

    txtAditional.value=aditional.toFixed(2);

    let priceAndAditional=aditionalMealEnter(price,aditional);
    let iva=aditionalIvaEnter(priceAndAditional);

    alert(`Se supone que se hizo el calculo: ${iva}`)
    txtIva.value=Number(iva).toFixed(2);
} */



btnCalc.addEventListener('click',()=>{
    
    let price=Number(txtPrice.value);
    let ivaa=Number(txtIva.value);
    let aditional=Number(txtAditional.value);

    if (price) {
        let subtotal=subtotalEnter(price,ivaa);
        let total=totalEnter(subtotal,ivaa);
    
        // txtPrice.value=price;
        // txtIva.value=Number(ivaa);



        if(aditional){
        let priceAndAditional=aditionalMealEnter(price,aditional);
        let ivaAditional=aditionalIvaEnter(priceAndAditional);
        let subtotalAditional=aditionalSubtotalEnter(priceAndAditional,ivaAditional);
        let totalAditional=aditionalTotalEnter(subtotalAditional,ivaAditional);

        // txtIva.value=ivaEnter;
        txtSubtotal.value=Number(subtotalAditional).toFixed(2);
        txtTotal.value=Number(totalAditional).toFixed(2);
        }else{
            txtAditional.value=Number(0.00).toFixed(2);
            // txtIva.value=Number(ivaAditional);
            txtSubtotal.value=Number(subtotal).toFixed(2);
            txtTotal.value=Number(total).toFixed(2);
        }
    }else{
        alert(`Select a meal to calculate the total price`);
    }
});


btnClean.addEventListener('click',()=>{
    cmbMeal.selectedIndex=0
    
    cmbAditional.innerHTML='';
    let defaultOption=document.createElement('option');
    defaultOption.value=''
    defaultOption.textContent='-- SELECT AN OPTION --'
    defaultOption.selected=true;
    defaultOption.disabled=true;
    cmbAditional.appendChild(defaultOption);

    txtPrice.value='';
    txtIva.value='';
    txtSubtotal.value='';
    txtTotal.value='';
    txtAditional.value='';
});


//! Trash
/* switch (Number(mealId)) {
    case 1:
        if(true){
            selectAditional=aditionalOneLis.find((adOne)=>adOne.id===code);
            // let ivaAditional=parseFloat(txtIva.value).toFixed(2);
            let price=Number(txtPrice.value);
            let aditional=Number(selectAditional.priceAditional);
            txtAditional.value=aditional.toFixed(2);
            let iva=Number(txtIva.value).toFixed(2);
            // txtIva.value='';
            let priceAndAditional=aditionalMealEnter(price,aditional);
            let ivaEnter=aditionalIvaEnter(priceAndAditional,iva);

            txtIva.value=Number(ivaEnter);
        }
        break;

    case 2:
        if(true){
            selectAditional=aditionalTwoList.find((adTwo)=>adTwo.id===code);
            // let ivaAditional=parseFloat(txtIva.value).toFixed(2);
            let price=Number(txtPrice.value).toFixed(2);
            let aditional=Number(selectAditional.priceAditional).toFixed(2);
            txtAditional.value=aditional;
            // txtIva.value='';
            let priceAndAditional=Number(aditionalMealEnter(price,aditional)).toFixed(2)
            let ivaEnter=Number(aditionalIvaEnter(priceAndAditional)).toFixed(2);

            txtIva.value=ivaEnter;
        }
        break;
    case 3:
        if(true){
            selectAditional=aditionalThreeList.find((adThree)=>adThree.id===code);
            // let ivaAditional=parseFloat(txtIva.value).toFixed(2);
            let price=Number(txtPrice.value).toFixed(2);
            let aditional=Number(selectAditional.priceAditional).toFixed(2);
            txtAditional.value=aditional;
            // txtIva.value='';
            let priceAndAditional=Number(aditionalMealEnter(price,aditional)).toFixed(2)
            let ivaEnter=Number(aditionalIvaEnter(priceAndAditional)).toFixed(2);

            txtIva.value=ivaEnter;
        }
        break;
} */