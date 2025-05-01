import { ClassEstudiante } from "../../domain/interface/model/estudiante.model";
import { RepositoryEstudiante } from "../../domain/interface/repository/repositoryStudent.repository.interface";

export class CaseUseGetAllStudent{
    constructor(private repo:RepositoryEstudiante) {}

    async run():Promise<ClassEstudiante[]>{
        return this.repo.getAll()
    }
}
