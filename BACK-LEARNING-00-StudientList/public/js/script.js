import { cargaEstudiantes, crearEstudiante } from "./load/load.js"
import { tablaEstudiantes } from "./util/util.js"


document.addEventListener("DOMContentLoaded",async ()=>{
    const estudiante=await cargaEstudiantes()
    tablaEstudiantes(estudiante)
})

document.querySelector("#btnAbrirMenuMobile").addEventListener("click",()=>{
    document.querySelector(".nav_container").classList.add("nav_visible")
})

document.querySelector("#btnCerrarMenuMobile").addEventListener("click",()=>{
    document.querySelector(".nav_container").classList.remove("nav_visible")
})

document.querySelector(".form_content").addEventListener("submit",async (e)=>{
    e.preventDefault()
    console.log(`Abriendo formulario...`);

    const estudiante={
        // id:Number(document.querySelector("#txtId").value),
        nombre:document.querySelector("#txtNombre").value,
        apellido:document.querySelector("#txtApellido").value,
        edad:Number(document.querySelector("#txtEdad").value)
    }

    console.log(`Estudiante cargado: `,estudiante);
    crearEstudiante(estudiante)
})
