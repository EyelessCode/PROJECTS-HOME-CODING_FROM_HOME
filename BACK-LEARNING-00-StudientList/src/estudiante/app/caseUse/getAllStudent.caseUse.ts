import { ClassEstudiante } from "../../domain/interface/model/estudiante.model";
import { IRepositoryEstudiante } from "../../domain/interface/repository/repositoryStudent.repository.interface";

export class CaseUseGetAllStudent{
    constructor(private repo:IRepositoryEstudiante) {}

    async run():Promise<ClassEstudiante[]>{
        return this.repo.getAll()
    }
}
