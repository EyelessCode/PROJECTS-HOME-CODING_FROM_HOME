const { response } = require("express");

fetch('/api/client').then(response=>response.json()).then(data=>{
    const listContainer=document.getElementById('clientList')
    data.forEach(client => {
        const listItems=document.createElement('li')
        listItems.textContent=`${client.name} ${client.lastname} ${client.ic} (${client.age})`
        listContainer.appendChild(listItems)
    });
})