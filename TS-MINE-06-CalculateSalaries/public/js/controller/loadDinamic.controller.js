import {workerList} from '../data/typeWorker.data.js';
import {getChangeList} from '../repository/getWorker.repository.js'

const cmbWorker=document.getElementById('cmbWorker');
const txtSalary=document.getElementById('txtSalary');
const txtBonusOrDiscount=document.getElementById('txtBonusOrDiscount');
const txtTotal=document.getElementById('txtTotal');
const btncalculate=document.getElementById('btncalculate');
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
    let code=Number(cmbWorker.options[Number(cmbWorker.selectedIndex)].values);
    let selected=workerList.find((worker)=>worker.id===code);
    
    if (selected) {
        console.log(`si vale`);
        switch (selected.id) {
            case 1:
    /*             let code=Number(cmbWorker.options[Number(cmbWorker.selectedIndex)].values);
                let selected=workerList.find((worker)=>worker.id===code);
                txtSalary */
                getChangeList();
    
                break;
            case 2:
                getChangeList();
                
                break;
            case 3:
                getChangeList();
                
                break;
        }
    }

});

