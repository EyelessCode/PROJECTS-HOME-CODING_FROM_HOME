import {workerList} from '../data/typeWorker.data.js';

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