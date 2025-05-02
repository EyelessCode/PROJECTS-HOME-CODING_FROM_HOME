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
    private mapeoDominio(student:PostgresStudent):ClassEstudiante{
        return new ClassEstudiante(
            new IdStudent(student.id),
            new NombreStudent(student.nombre),
            new ApellidoStudent(student.apellido),
            new EdadStudent(student.edad)
        )
    }

    client:Pool
    constructor(databaseUrl:string){
        this.client=new Pool({
            connectionString:databaseUrl
        })
    }
    
    async getAll(): Promise<ClassEstudiante[]> {
        const query={
            text:`SELECT * FROM student`
        }

        const resultado=await this.client.query<PostgresStudent>(query)
        return resultado.rows.map((row)=>this.mapeoDominio(row))
    }

    async getOneById(id: IdStudent): Promise<ClassEstudiante | null> {
        const query={
            text:`SELECT * FROM student WHERE id=$1`,
            values:[id.id]
        }

        const resultado=await this.client.query<PostgresStudent>(query)
        if(resultado.rows.length===0)throw null

        const fila=resultado.rows[0]

        return this.mapeoDominio(fila)
    }

    async create(student: ClassEstudiante): Promise<void> {
        const query={
            text:`INSERT INTO student (id,nombre,apellido,edad) VALUES($1,$2,$3,$4)`,
            values:[student.id.id,student.nombre.nombre,
                student.apellido.apellido,student.edad.edad
            ]
        }

        await this.client.query(query)
    }

    async edit(student: ClassEstudiante): Promise<void> {
        const query={
            text:`UPDATE student SET nombre=$1,apellido=$2,edad=$3 `+
            `WHERE id=$4`,
            values:[student.nombre.nombre,student.apellido.apellido,
                student.edad.edad,student.id.id
            ]
        }

        await this.client.query(query)
    }
    async delete(id: IdStudent): Promise<void> {
        const query={
            text:`DELETE FROM student WHERE id=$1`,
            values:[id.id]
        }

        await this.client.query(query)
    }

}
