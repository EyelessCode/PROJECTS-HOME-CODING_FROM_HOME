import {workerList} from '../data/typeWorker.data.js'

const txtSalary=document.getElementById('txtSalary');

export function getChangeList() {
    let code=Number(cmbWorker.options[Number(cmbWorker.selectedIndex)].values);
    let selected=workerList.find((worker)=>worker.id===code);
    txtSalary.value=Number(selected.salary).toFixed(2);
}