import { ClassEstudiante } from "../../domain/interface/model/estudiante.model";
import { IRepositoryEstudiante } from "../../domain/interface/repository/repositoryStudent.repository.interface";
import { ApellidoStudent } from "../../domain/validation/model/apellidoStudent.value";
import { EdadStudent } from "../../domain/validation/model/edadStudent.value";
import { IdStudent } from "../../domain/validation/model/idStudent.value";
import { NombreStudent } from "../../domain/validation/model/nombreStudent.value";

export class CaseUseCreateStudent{
    constructor(private repo:IRepositoryEstudiante) {}

    async run(id:number,nombre:string,
            apellido:string,edad:number):Promise<void>{
        const estudiante=new ClassEstudiante(
            new IdStudent(id),
            new NombreStudent(nombre),
            new ApellidoStudent(apellido),
            new EdadStudent(edad)
        )

        return this.repo.create(estudiante)
    }
}
