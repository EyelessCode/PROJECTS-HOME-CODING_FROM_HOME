import { Pool } from "pg";
import { ClassEstudiante } from "../../domain/interface/model/estudiante.model";
import { IRepositoryEstudiante } from "../../domain/interface/repository/repositoryStudent.repository.interface";
import { IdStudent } from "../../domain/validation/model/idStudent.value";
import { NombreStudent } from "../../domain/validation/model/nombreStudent.value";
import { ApellidoStudent } from "../../domain/validation/model/apellidoStudent.value";
import { EdadStudent } from "../../domain/validation/model/EdadStudent.value";

type PostgresStudent={
    id:number,
    nombre:string,
    apellido:string,
    edad:number
}

export class RepositoryPostgresStudent implements IRepositoryEstudiante{
    client:Pool
    constructor(databaseUrl:string){
        this.client=new Pool({
            connectionString:databaseUrl
        })
    }

    private mapeoDominio(student:PostgresStudent):ClassEstudiante{
        return new ClassEstudiante(
            new IdStudent(student.id),
            new NombreStudent(student.nombre),
            new ApellidoStudent(student.apellido),
            new EdadStudent(student.edad)
        )
    }
    
    async getAll(): Promise<ClassEstudiante[]> {
        const query={
            text:`SELECT * FROM student`
        }

        const resultado=await this.client.query<PostgresStudent>(query)

        return resultado.rows.map((row)=>this.mapeoDominio(row))
    }
    async getOneById(id: IdStudent): Promise<ClassEstudiante | null> {
        throw new Error("Method not implemented.");
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
