import { CaseUseCreateStudent } from "../../estudiante/app/caseUse/createStudent.caseUse";
import { CaseUseDeleteStudent } from "../../estudiante/app/caseUse/deleteStudent.caseUse";
import { CaseUseEditStudent } from "../../estudiante/app/caseUse/editStudent.caseUse";
import { CaseUseGetAllStudent } from "../../estudiante/app/caseUse/getAllStudent.caseUse";
import { CaseUseGetOneByIdStudent } from "../../estudiante/app/caseUse/getOnebyIdStudent.caseUse";
import { RepositoryPostgresStudent } from "../../estudiante/infrastructure/repository/repositoryStudent.postgres.repository";
import { RepositoryInMemoryStudent } from "../../estudiante/infrastructure/test/repository/repositoryInMemoryStudent.repository";

const repo=new RepositoryPostgresStudent(`postgresql://eyelesscode:cris03022@localhost:5432/student_temp`)

const container={
    student:{
        getAll:new CaseUseGetAllStudent(repo),
        getOneById:new CaseUseGetOneByIdStudent(repo),
        create:new CaseUseCreateStudent(repo),
        edit:new CaseUseEditStudent(repo),
        delete:new CaseUseDeleteStudent(repo),
    }
}

export {container}
