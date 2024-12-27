import {workerList} from '../data/typeWorker.data.js'

const cmbWorker=document.getElementById('cmbWorker');
const txtBonusOrDiscount=document.getElementById('txtBonusOrDiscount');
const labelBonusOrDiscount=document.getElementById('labelBonusOrDiscount');
const txtSalary=document.getElementById('txtSalary');

export function getChangeList() {
    // console.log(`si pendejo: ${selected.salary}`);
    // let i=cmbWorker
    let code=Number(cmbWorker.options[Number(cmbWorker.selectedIndex)].value);
    // let code=Number(cmbWorker.options[i].value);
    let selected=workerList.find((worker)=>worker.id===code);
    txtSalary.value=Number(selected.salary).toFixed(2);
    
    if (selected.worker==='repository') {
        console.log(`Hoal`);
        labelBonusOrDiscount.textContent="Bonus: "
        txtBonusOrDiscount.value=0.10;
    }else if(selected.worker==="atm"){
        labelBonusOrDiscount.textContent="Fixed: "
        txtBonusOrDiscount.value=0.00;
    }else if(selected.worker==="supervisor"){
        labelBonusOrDiscount.textContent="Discount: "
        txtBonusOrDiscount.value=0.11;
    }
}