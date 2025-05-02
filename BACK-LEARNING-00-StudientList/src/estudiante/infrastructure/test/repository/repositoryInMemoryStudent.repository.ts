import { ClassEstudiante } from "../../../domain/interface/model/estudiante.model";
import { IRepositoryEstudiante } from "../../../domain/interface/repository/repositoryStudent.repository.interface";
import { IdStudent } from "../../../domain/validation/model/idStudent.value";

export class RepositoryInMemoryStudent implements IRepositoryEstudiante{
    private estudiante:ClassEstudiante[]=[]

    async getAll(): Promise<ClassEstudiante[]> {
        return this.estudiante
    }

    async getOneById(id: IdStudent): Promise<ClassEstudiante | null> {
        return this.estudiante.find((student)=>student.id.id===id.id)||null
    }

    async create(student: ClassEstudiante): Promise<void> {
        throw new Error("Method not implemented.");
    }

    async edit(student: ClassEstudiante): Promise<void> {
        throw new Error("Method not implemented.");
    }

    async delete(id: IdStudent): Promise<void> {
        throw new Error("Method not implemented.");
    }
}
