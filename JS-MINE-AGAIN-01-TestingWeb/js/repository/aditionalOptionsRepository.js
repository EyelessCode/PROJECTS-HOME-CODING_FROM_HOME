// import {aditionalOneLis,aditionalTwoList,aditionalThreeList} from '../BD.js';

const cmbAditional=document.getElementById('cmbAditional');

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