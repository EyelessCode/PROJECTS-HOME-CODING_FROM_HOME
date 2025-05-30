import { ClassEstudiante } from "../../domain/interface/model/estudiante.model";
import { IRepositoryEstudiante } from "../../domain/interface/repository/repositoryStudent.repository.interface";
import { IdStudent } from "../../domain/validation/model/idStudent.value";
import { StudentNotFound } from "../../domain/validation/util/studentNotFound.util";

export class CaseUseGetOneByIdStudent{
    constructor(private repo:IRepositoryEstudiante){}

    async run(id:number):Promise<ClassEstudiante>{
        const estudiante=await this.repo.getOneById(new IdStudent(id))

        if(!estudiante)throw new StudentNotFound(`No se pudo encontrar el `+
            `estudiante ${id}!`)

        return estudiante
    }
}
