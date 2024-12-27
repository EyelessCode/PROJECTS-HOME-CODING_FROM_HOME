import {workerList} from '../data/typeWorker.data.js'

const cmbWorker=document.getElementById('cmbWorker');
const txtBonusOrDiscount=document.getElementById('txtBonusOrDiscount');
const labelBonusOrDiscount=document.getElementById('labelBonusOrDiscount');
const txtTotal=document.getElementById('txtTotal');
const txtSalary=document.getElementById('txtSalary');

export function getChangeList() {
    // console.log(`si pendejo: ${selected.salary}`);
    // let i=cmbWorker
    let code=Number(cmbWorker.options[Number(cmbWorker.selectedIndex)].value);
    // let code=Number(cmbWorker.options[i].value);
    let selected=workerList.find((worker)=>worker.id===code);
    txtSalary.value=Number(selected.salary).toFixed(2);
    
    
    if (selected.worker==='repository') {
        txtTotal.value=Number(0.00).toFixed(2)
        // console.log(`Hoal`);
        labelBonusOrDiscount.textContent="Bonus: "
        txtBonusOrDiscount.value=Number(0.10);
    }else if(selected.worker==="atm"){
        txtTotal.value=Number(0.00).toFixed(2)
        txtBonusOrDiscount.value=Number(0.00)


        labelBonusOrDiscount.textContent="Fixed: "
        txtBonusOrDiscount.value=Number(0.00);
    }else if(selected.worker==="supervisor"){
        txtTotal.value=Number(0.00).toFixed(2)


        labelBonusOrDiscount.textContent="Discount: "
        txtBonusOrDiscount.value=Number(0.11);
    }
}

export function repositoryWork() {
    let code=Number(cmbWorker.options[Number(cmbWorker.selectedIndex)].value)
    let selected=workerList.find((workerText)=>workerText.id===code)

    console.log(`Hoal`);
    let worker=selected.worker;
    // let worker=String("Repository");
    // let salaryWork = Number(15_890);
    let salaryWork=Number(txtSalary.value)
    let bonus = Number(salaryWork * txtBonusOrDiscount.value);
    let salary = Number(bonus + salaryWork);
    // const bonus:number=0.1
    // const salaryWithBonus:number=salary*bonus;
    console.log(`It works - Work: ${worker} - Salary: ${salary}`);
    txtTotal.value=Number(salary).toFixed(2)
    return salary;
}

export function atmWork() {
    let code=Number(cmbWorker.options[Number(cmbWorker.selectedIndex)].value)
    let selected=workerList.find((workerText)=>workerText.id===code)

    console.log(`Hoal`);
    let worker=selected.worker;
    let salaryWork=Number(txtSalary.value)
    // let salaryWork = Number(25_630.89);
    console.log(`It works - Work: ${worker} - Salary: ${salaryWork}`);
    txtTotal.value=Number(salaryWork).toFixed(2)
    return salaryWork;
}

export function supervisorWork() {
    let code=Number(cmbWorker.options[Number(cmbWorker.selectedIndex)].value)
    let selected=workerList.find((workerText)=>workerText.id===code)

    console.log(`Hoal`);
    let worker=selected.worker;
    let salaryWork=Number(txtSalary.value)
    const discount = Number(salaryWork * txtBonusOrDiscount.value);
    // this.workerModel.salary = 35_560.20;
    const salary = salaryWork - discount;
    console.log(`It works - Work: ${worker} - Salary: ${salary}`);
    txtTotal.value=Number(salary).toFixed(2)
    return salary;
}