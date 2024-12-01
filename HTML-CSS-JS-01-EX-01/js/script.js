import { customerList, sitieList } from "./BD.js";
import { subtotal, total } from "./payment.js";

const txtCode = document.getElementById('txtCode');
const btnSearch = document.getElementById('btnSearch');

const txtIc = document.getElementById('txtIc');
const txtNames = document.getElementById('txtNames');

const cmbSities = document.getElementById('cmbSities');
const txtKms = document.getElementById('txtKms');
const txtCost = document.getElementById('txtCost');

const txtPeople = document.getElementById('txtPeople');
const txtSubtotal = document.getElementById('txtSubtotal');
const txtIva = document.getElementById('txtIva');
const txtTotal = document.getElementById('txtTotal');
const btnCalculate = document.getElementById('btnCalculate');
const btnClear = document.getElementById('btnClear');

window.addEventListener('DOMContentLoaded', () => {
    sitieList.forEach((place) => {
        let option = document.createElement('option');
        option.value = place.id;
        option.textContent = place.place;
        cmbSities.appendChild(option);
    });
});

cmbSities.addEventListener('click', () => {
    /* Acá sólo se obtiene el index del 'combobox' */
    let i = cmbSities.selectedIndex;

    /* Acá estamos instalando el index en los valores de las 
    opciones del 'combobox' (opciones) */
    let code = cmbSities.options[i].value;

    /* Acá estamos creando una variable que tiene almacenada
    la lista importada de clientes, lo que hará es hacer una
    una búsqueda, si es equivalente el index con el id del valor de
    la propiedad del array; entonces, almacenará en la variable
    el objeto del array.
    ! En pocas palabras, agarramos un index, si es igual al id
    ! del objeto obtienes el objeto. */
    const select = sitieList.find(place => place.id == parseInt(code));

    /* Gracias a lo de arriba, podemos establecerlo para establecer
    valores en los inputs. */
    txtKms.value = select.travelInKm;
    txtCost.value = select.cost;
});

btnSearch.addEventListener('click', () => {
    //// let door = false;
    /* Obtengo el valor del input code. */
    const codigo = parseInt(txtCode.value);

    /* Acá hago una búsqueda  valor del input y si lo equivalente
    al id del objeto del array, entonces obtengo el objeto del array. */
    const select = customerList.find((customer) => customer.id === codigo);

    /* Acá gracias al 'input codigo' podemos hacer un 'if';
    es decir, una condición. Si el valor del input es equivalente
    al parámetro de la lista , entonces, obtengo el objeto del array. */
    if (select) {
        //// door = true;
        txtIc.value = select.ic;
        txtNames.value = select.names;
    } else {
        alert('This customer is not in the list');
        txtIc.value='';
        txtNames.value='';
    }
});

btnClear.addEventListener('click', () => {
    txtCode.value = '';
    txtIc.value = '';
    txtNames.value = '';
    cmbSities.value='';
    txtKms.value = '0.00';
    txtCost.value = '0.00';
    txtPeople.value = '';
    txtSubtotal.value = '0.00';
    // txtIva.value='';
    txtTotal.value = '0.00';
});

btnCalculate.addEventListener('click', () => {
    const amount = parseInt(txtPeople.value);
    const cost = parseFloat(txtCost.value);

    const iva = parseFloat(txtIva.value);

    const subtotalEntrada = subtotal(amount, cost);
    const totalEntrada = total(subtotalEntrada, iva);

    txtSubtotal.value = String(subtotalEntrada);
    txtTotal.value = String(totalEntrada);


    /*     const amount = parseInt(txtPeople.value);
        const iva=parseFloat(txtIva);
        const select=sitieList.find((place)=>place.id===amount);
    
        const subtotalEntrada=subtotal(amount,select.cost);
        const totalEntrada=total(subtotalEntrada,iva);
    
        txtSubtotal.value=parseFloat(subtotalEntrada);
        txtTotal.value=parseFloat(totalEntrada); */
});