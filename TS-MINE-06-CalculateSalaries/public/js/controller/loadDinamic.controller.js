import {workerList} from '../data/typeWorker.data.js';
import {getChangeList,atmWork,repositoryWork,supervisorWork} from '../repository/getWorker.repository.js'
// import {} from '../'

const cmbWorker=document.getElementById('cmbWorker');
const txtSalary=document.getElementById('txtSalary');
const labelBonusOrDiscount=document.getElementById('labelBonusOrDiscount');
const txtBonusOrDiscount=document.getElementById('txtBonusOrDiscount');
const txtTotal=document.getElementById('txtTotal');
const btnCalculate=document.getElementById('btnCalculate');
const btnDelete=document.getElementById('btnDelete');

window.addEventListener('DOMContentLoaded',()=>{
    workerList.forEach((workers)=>{
        const option=document.createElement('option');
        option.value=workers.id;
        option.textContent=workers.worker;
        cmbWorker.appendChild(option)
    });
});

cmbWorker.addEventListener('change',()=>{
    let code=Number(cmbWorker.options[Number(cmbWorker.selectedIndex)].value);
    let selected=workerList.find((worker)=>worker.id===code);
    
    if (selected) {
        // console.log(`si vale`); 
        switch (selected.id) {
            case 1:
                
                getChangeList();
                btnCalculate.addEventListener('click',()=>repositoryWork());
                
    
                break;
            case 2:
                getChangeList();
                btnCalculate.addEventListener('click',()=>atmWork());

                
                break;
            case 3:
                getChangeList();
                btnCalculate.addEventListener('click',()=>supervisorWork());

                
                break;
        }
    }

});

btnDelete.addEventListener('click',()=>{
    cmbWorker.value='';
    cmbWorker.selectedIndex=0;
    txtTotal.value=Number(0.00).toFixed(2)
    txtSalary.value=Number(0.00).toFixed(2)
    txtBonusOrDiscount.value=Number(0.00).toFixed(2)
    labelBonusOrDiscount.textContent=String('')
})
