import { ApellidoStudent } from "../../validation/model/apellidoStudent.value"
import { EdadStudent } from "../../validation/model/EdadStudent.value"
import { IdStudent } from "../../validation/model/idStudent.value"
import { NombreStudent } from "../../validation/model/nombreStudent.value"

export class ClassEstudiante{
    id:IdStudent
    nombre:NombreStudent
    apellido:ApellidoStudent
    edad:EdadStudent

    constructor(id:IdStudent,nombre:NombreStudent,
        apellido:ApellidoStudent,edad:EdadStudent
    ) {
        this.id=id
        this.nombre=nombre,
        this.apellido=apellido,
        this.edad=edad
    }

    public nombreAndApellido(){
        return `${this.nombre} - ${this.apellido}`
    }

    public mapeoPrimitivo(){
        return{
            id:this.id.id,
            nombre:this.nombre.nombre,
            apellido:this.apellido.apellido,
            edad:this.edad.edad
        }
    }
}
