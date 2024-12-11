import { mealList,aditionalOneLis,aditionalTwoList,aditionalThreeList } from './BD.js';
import {ivaEnter,subtotalEnter,totalEnter} from './math.js';

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
    let i=cmbMeal.selectedIndex;
    let code=cmbMeal.options[i].value;
    let mealSelection=mealList.find((meal)=>meal.id===parseInt(code));
    // alert(`Índice: ${code} o ${mealSelection.id}`);

    let iva=ivaEnter(mealSelection.price).toFixed(2);

    
    txtIva.value=parseFloat(iva).toFixed(2);
    txtPrice.value=parseFloat(mealSelection.price).toFixed(2);
    txtAditional.value='';
    // alert(`se está ejecunado...`);
    switch(parseInt(code)){
        case 1:
            cmbAditional.innerHTML='';

            // if(true){
                let option=document.createElement('option');
                option.value=''
                option.textContent='-- ANY --'
                option.selected=true;
                option.disabled=false;
                cmbAditional.appendChild(option);

            // }
            
            aditionalOneLis.forEach((adOne)=>{
                let option=document.createElement('option');
                option.value=adOne.id;
                option.textContent=adOne.name;
                cmbAditional.appendChild(option);
            });
            
            if(true){
                cmbAditional.addEventListener('change',()=>{
                    // alert(`hoal!`)
                    // console.log(`hoal!`)
                    let i=cmbAditional.selectedIndex;
                    let code=cmbAditional.options[i].value;
                    let aditionalSelect=aditionalOneLis.find((adOne)=>adOne.id===parseInt(code));
                    // alert(`el es ${code} ${aditionalSelect.id}`)
                });
            }

        break;
        case 2:
            cmbAditional.innerHTML='';

            if(true){
                let option=document.createElement('option');
                option.value=''
                option.textContent='-- ANY --'
                option.selected=true;
                option.disabled=false;
                cmbAditional.appendChild(option);
            }

            aditionalTwoList.forEach((adTwo)=>{
                let option=document.createElement('option');
                option.value=adTwo.id;
                option.textContent=adTwo.name;
                cmbAditional.appendChild(option);
            });

            if(true){
                cmbAditional.addEventListener('change',()=>{
                    // alert(`hoal!`)
                    // console.log(`hoal!`)
                    let i=cmbAditional.selectedIndex;
                    let code=cmbAditional.options[i].value;
                    let aditionalSelect=aditionalTwoList.find((adTwo)=>adTwo.id===parseInt(code));

                    let aditional=Number(aditionalSelect.priceAditional).toFixed(2);

                    txtAditional.value=aditional;
                });
            }
        break;
        case 3:
            cmbAditional.innerHTML='';

            if(true){
                let option=document.createElement('option');
                option.value=''
                option.textContent='-- ANY --'
                option.selected=true;
                option.disabled=false;
                cmbAditional.appendChild(option);
            }

            aditionalThreeList.forEach((adThree)=>{
                let option=document.createElement('option');
                option.value=adThree.id;
                option.textContent=adThree.name;
                cmbAditional.appendChild(option);
            });

            if(true){
                cmbAditional.addEventListener('change',()=>{
                    // alert(`hoal!`)
                    // console.log(`hoal!`)
                    let i=cmbAditional.selectedIndex;
                    let code=cmbAditional.options[i].value;
                    let aditionalSelect=aditionalThreeList.find((adThree)=>adThree.id===parseInt(code));

                    let aditional=Number(aditionalSelect.priceAditional).toFixed(2);

                    txtAditional.value=aditional;
                });
            }
        break;

    }
});



// const buttonCalc=
btnCalc.addEventListener('click',()=>{
    // console.log(`hoal`)
    let i=cmbMeal.selectedIndex;
    let code=cmbMeal.options[i].value;
    let mealSelection=mealList.find((meal)=>meal.id===parseInt(code));
    
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
