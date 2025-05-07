import { eliminarEstudiante } from "../load/load.js";

function tablaEstudiantes(student) {
    const cuerpoTabla=document.querySelector(".tbody_content")
    student.sort((a,b)=>a.id-b.id)
    student.forEach((estudiante) => {
        const fila=document.createElement("tr")
        let celda=document.createElement("td")
        celda.textContent=Number(estudiante.id)
        fila.appendChild(celda)

        celda=document.createElement("td")
        celda.textContent=String(estudiante.nombre)
        fila.appendChild(celda)

        celda=document.createElement("td")
        celda.textContent=String(estudiante.apellido)
        fila.appendChild(celda)
        
        celda=document.createElement("td")
        celda.textContent=Number(estudiante.edad)
        fila.appendChild(celda)

        const acciones=document.createElement("td")
        const btnEliminar=document.createElement("button")
        btnEliminar.textContent="ELIMINAR"
        btnEliminar.onclick=()=>eliminarEstudiante(Number(estudiante.id))
        acciones.appendChild(btnEliminar)

        fila.appendChild(acciones)
        cuerpoTabla.appendChild(fila)
    });
}

export {tablaEstudiantes}
