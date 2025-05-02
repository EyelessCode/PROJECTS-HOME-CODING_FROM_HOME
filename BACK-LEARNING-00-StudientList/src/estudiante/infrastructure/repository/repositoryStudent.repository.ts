import { ClassEstudiante } from "../../domain/interface/model/estudiante.model";
import { IRepositoryEstudiante } from "../../domain/interface/repository/repositoryStudent.repository.interface";
import { IdStudent } from "../../domain/validation/model/idStudent.value";

export class RepositoryStudent implements IRepositoryEstudiante{
    getAll(): Promise<ClassEstudiante[]> {
        throw new Error("Method not implemented.");
    }
    getOneById(id: IdStudent): Promise<ClassEstudiante | null> {
        throw new Error("Method not implemented.");
    }
    create(student: ClassEstudiante): Promise<void> {
        throw new Error("Method not implemented.");
    }
    edit(student: ClassEstudiante): Promise<void> {
        throw new Error("Method not implemented.");
    }
    delete(id: IdStudent): Promise<void> {
        throw new Error("Method not implemented.");
    }

}
