import { URL } from "../api/api.url.js";

async function cargaEstudiantes() {
    try {
        console.log(`Cargando...`);
        const response=await fetch(URL)
        const estudiante=await response.json()
        console.log(`Estudiantes: `,estudiante);
        if (!response.ok) {
            return alert(`HAY UN PROBLEMA CON LA BASE DE DATOS!`)
        }
        return estudiante
    } catch (error) {
        console.error(`Oh no...`);
        alert(`Carga de la Base de datos fallida!`)
    }
}

async function eliminarEstudiante(id) {
    try {
        const response=await fetch(`${URL}/${id}`,{
            method:'DELETE'
        })

        console.log(`Eliminando...`);
        if(response.ok){
            alert(`Estudiante eliminado!`)
            cargaEstudiantes()
        }else{
            alert(`Eliminación fallida!`)
        }
    } catch (error) {
        console.error(`Oh no... Algo salió mal: `,error);
        alert(`Eliminación del servidor fallida!`)
    }
}

async function crearEstudiante(estudiante) {
    try {
        const response=await fetch(URL,
            {
                method:'POST',
                headers:{
                    'Content-Type':'application/json'
                },
                body:JSON.stringify(estudiante)
            }
        )
    
        const data=await response.json()
        console.log(`Respuesta recibida: `,data);
        if (response.ok) {
            alert(`Estudiante Registrado!`)
            document.querySelector(".form_content").reset()
            cargaEstudiantes()
        } else {
            alert(`No se pudo registrar un estudiante!`)
        }
    } catch (error) {
        console.error(`Error: `,error);
        console.error(`Respuesta caída: `,data);
        alert(`El servidor tuvo un problema al crear un estudiante!`)
    }
}

export {cargaEstudiantes,eliminarEstudiante,crearEstudiante}
