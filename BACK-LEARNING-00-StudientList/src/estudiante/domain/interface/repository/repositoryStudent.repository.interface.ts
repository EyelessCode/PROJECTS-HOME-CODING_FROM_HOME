import { IdStudent } from '../../validation/model/idStudent.value';
import { ClassEstudiante } from '../model/estudiante.model';

export interface IRepositoryEstudiante{
    getAll():Promise<ClassEstudiante[]>
    getOneById(id:IdStudent):Promise<ClassEstudiante|null>
    create(student:ClassEstudiante):Promise<void>
    edit(student:ClassEstudiante):Promise<void>
    delete(id:IdStudent):Promise<void>
}
