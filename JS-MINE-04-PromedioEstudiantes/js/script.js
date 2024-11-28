import {listEstudiantes} from './BD.js';
import {calculcarCalificaciones,calcularPromedio} from './promedio.js';

const cmbEstudiante=document.getElementById('cmbEstudiante');
const txtEdad=document.getElementById('txtEdad');
const txtCurso=document.getElementById('txtCurso');
const txtMate=document.getElementById('txtMate');
const txtFisica=document.getElementById('txtFisica');
const txtQuimica=document.getElementById('txtQuimica');
const txtHistoria=document.getElementById('txtHistoria');
const txtGeogra=document.getElementById('txtGeogra');
const txtCiencia=document.getElementById('txtCiencia');
const txtPromedio=document.getElementById('txtPromedio');
const txtSuma=document.getElementById('txtSuma');
const btnPromedio=document.getElementById('btnPromedio');
const btnEliminar=document.getElementById('btnEliminar');

window.addEventListener('DOMContentLoaded',()=>{
    listEstudiantes.forEach((estudiante)=>{
        const opcion=document.createElement('option');
        opcion.value=estudiante.id;
        opcion.textContent=estudiante.nombre;

        cmbEstudiante.appendChild(opcion);
    })

});

cmbEstudiante.addEventListener('change',()=>{
    let i=cmbEstudiante.selectedIndex;
    let codigo=cmbEstudiante.options[i].value;
    const seleccion=listEstudiantes.find((lista)=>lista.id===parseInt(codigo));

    txtEdad.value=String(seleccion.edad);
    txtCurso.value=String(seleccion.curso);
    txtMate.value=String(seleccion.calificacionMatematicas);
    txtFisica.value=String(seleccion.calificacionFisica);
    txtQuimica.value=String(seleccion.calificacionQuimica);
    txtHistoria.value=String(seleccion.calificacionHistoria);
    txtGeogra.value=String(seleccion.calificacionGeografia);
    txtCiencia.value=String(seleccion.calificacionCiencias);

    txtPromedio.value='';
    txtSuma.value='';

    //! alert(`índice: ${seleccion.id} nombre: ${seleccion.nombre}`);
});

btnPromedio.addEventListener('click',()=>{
/*     let listCalificacion={
        calificacionMatematicas:parseFloat(txtMate.value),
        calificacionFisica:parseFloat(txtFisica.value),
        calificacionQuimica:parseFloat(txtQuimica.value),
        calificacionHistoria:parseFloat(txtHistoria.value),
        calificacionGeografia:parseFloat(txtGeogra.value),
        calificacionCiencias:parseFloat(txtCiencia.value)
    } */

    

    let matematica=parseFloat(txtMate.value);
    let fisica=parseFloat(txtFisica.value);
    let quimica=parseFloat(txtQuimica.value);
    let historia=parseFloat(txtHistoria.value);
    let geografia=parseFloat(txtGeogra.value);
    let ciencia=parseFloat(txtCiencia.value);

    let suma=calculcarCalificaciones(matematica,fisica,quimica,historia,geografia,ciencia);
    let promedio=calcularPromedio(suma);

    txtSuma.value=parseInt(suma);
    txtPromedio.value=parseFloat(promedio).toFixed(2);
});

btnEliminar.addEventListener('click',()=>{
    cmbEstudiante.value='';
    txtEdad.value='';
    txtCurso.value='';
    txtMate.value='';
    txtFisica.value='';
    txtQuimica.value='';
    txtHistoria.value='';
    txtGeogra.value='';
    txtCiencia.value='';
    txtPromedio.value='';
    txtSuma.value='';
})

/* btnPromedio.addEventListener('click',()=>{
    let matematica=parseFloat(txtMate.value);
    let fisica=parseFloat(txtFisica.value);
    let quimica=parseFloat(txtQuimica.value);
    let historia=parseFloat(txtHistoria.value);
    let geografia=parseFloat(txtGeogra.value);
    let ciencia=parseFloat(txtCiencia.value);

    let promedio=calcularPromedio(suma);

    txtPromedio.value=parseFloat(promedio);
}); */