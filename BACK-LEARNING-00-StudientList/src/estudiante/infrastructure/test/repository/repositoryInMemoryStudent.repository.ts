import { ClassEstudiante } from "../../../domain/interface/model/estudiante.model";
import { IRepositoryEstudiante } from "../../../domain/interface/repository/repositoryStudent.repository.interface";
import { IdStudent } from "../../../domain/validation/model/idStudent.value";
import { StudentNotFound } from "../../../domain/validation/util/studentNotFound.util";

export class RepositoryInMemoryStudent implements IRepositoryEstudiante{
    private estudiante:ClassEstudiante[]=[]

    async getAll(): Promise<ClassEstudiante[]> {
        return this.estudiante
    }

    async getOneById(id: IdStudent): Promise<ClassEstudiante | null> {
        return this.estudiante.find((student)=>student.id.id===id.id)||null
    }

    async create(student: ClassEstudiante): Promise<void> {
        this.estudiante.push(student)
    }

    async edit(student: ClassEstudiante): Promise<void> {
        if(!student.id)throw new StudentNotFound(`No se encontró el estudiante ?${student.id}?!`)

        const index=this.estudiante.findIndex((e)=>e.id.id===student.id.id)
        this.estudiante[index]=student
    }

    async delete(id: IdStudent): Promise<void> {
        if(!id.id)throw new StudentNotFound(`No se encontró el estudiante ?${id.id}?!`)
        
        this.estudiante=this.estudiante.filter((student)=>student.id.id!==id.id)
    }
}
