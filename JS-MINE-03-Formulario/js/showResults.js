import {first} from './calc.js';

const txtCode=document.getElementById('txtCode');
const txtName=document.getElementById('txtName');
const cmbMonth=document.getElementById('cmbMonth');
const txtSalary=document.getElementById('txtSalary');
const txtAdditionHour=document.getElementById('txtAdditionHour');
const txtCostHour=document.getElementById('txtCostHour');
const txtContributionPercentage=document.getElementById('txtContributionPercentage');
const txtContributionAmount=document.getElementById('txtContributionAmount');
const txtNetReceive=document.getElementById('txtNetReceive');
const calculate=document.getElementById('btnCalc');

calculate.addEventListener('click',()=>{
    let salary=parseFloat(txtSalary.value);
    let addHour=parseFloat(txtAdditionHour.value);
    const costHour=parseFloat(txtCostHour.value);
    const percentage=parseFloat(txtContributionPercentage.value);

    if (salary<=0) {
        alert('Input a valid salary.');
        return;
    }

    const totalHour=addHour*costHour;
    const salaryPlus=salary+totalHour;
    const additionalAmount=salaryPlus*(percentage/100);
    const netReceive=salaryPlus-additionalAmount;

    txtContributionAmount.value=additionalAmount.toFixed(2);
    txtNetReceive.value=netReceive.toFixed(2);
})