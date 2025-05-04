import { IRepositoryEstudiante } from "../../domain/interface/repository/repositoryStudent.repository.interface";
import { IdStudent } from "../../domain/validation/model/idStudent.value";
import { StudentNotFound } from "../../domain/validation/util/studentNotFound.util";

export class CaseUseDeleteStudent{
    constructor(private repo:IRepositoryEstudiante){}

    async run(id:number):Promise<void>{
        const estudiante=new IdStudent(id)

        const estudianteExiste=await this.repo.getOneById(estudiante)
        if(!estudianteExiste)throw new StudentNotFound(`No se encontró el estudiante ?${id}?!`)

        return this.repo.delete(estudiante)
    }
}
