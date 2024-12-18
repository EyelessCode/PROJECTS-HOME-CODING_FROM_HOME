import {aditionalOneList,aditionalTwoList,aditionalThreeList} from '../BD.js';
import {ivaEnter,aditionalMealEnter,aditionalIvaEnter} from '../math.js';

const cmbAditional=document.getElementById('cmbAditional');
const txtPrice=document.getElementById('txtPrice');
const txtIva=document.getElementById('txtIva');
const txtAditional=document.getElementById('txtAditional');
const txtSubtotal=document.getElementById('txtSubtotal');
const txtTotal=document.getElementById('txtTotal');

const defaultOptionText='-- ANY --'

export function populateAditionalOptions(list) {
    cmbAditional.innerHTML='';

    let defaultOption=document.createElement('option');
    defaultOption.value='';
    defaultOption.textContent=defaultOptionText;
    defaultOption.selected=true;
    defaultOption.disabled=false;
    cmbAditional.appendChild(defaultOption);

    list.forEach((adOne)=>{
        let option=document.createElement('option');
        option.value=adOne.id;
        option.textContent=adOne.name;
        cmbAditional.appendChild(option);
    });

}

export function aditionalEvent(mealId) {
    cmbAditional.addEventListener('change',()=>{
        let i=cmbAditional.selectedIndex;
        let code=Number(cmbAditional.options[Number(i)].value);
        let selectAditional;
        
        if (Number(code)===0) {
            let price=Number(txtPrice.value);
            let iva=ivaEnter(price);
            txtIva.value=iva.toFixed(2);
            txtAditional.value=Number(0.00).toFixed(2);
            txtSubtotal.value='';
            txtTotal.value='';
        }else if(mealId===1) {
            selectAditional=aditionalOneList.find((AdOne)=>AdOne.id===code);
        }else if(mealId===2){
            selectAditional=aditionalTwoList.find((AdTwo)=>AdTwo.id===code);
        }else if(mealId===3){
            selectAditional=aditionalThreeList.find((adThree)=>adThree.id===code);

            // txtAditional.value=selectAditional.
            //! I NEED TO MAKE A SWITCH
        }

        if (selectAditional) {
            // let selectAditional=selectAditional.priceAditional;

            let price=Number(txtPrice.value);
            let aditional=Number(selectAditional.priceAditional);

            txtAditional.value=aditional.toFixed(2);

            let priceAndAditional=aditionalMealEnter(price,aditional);
            let iva=aditionalIvaEnter(priceAndAditional);

            // alert(`Se supone que se hizo el calculo: ${iva}`)
            txtIva.value=Number(iva).toFixed(2);
            txtTotal.value='';
            txtSubtotal.value='';
        }
    });
    
}