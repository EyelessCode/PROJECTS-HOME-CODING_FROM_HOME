import { CaseUseCreateStudent } from "../../estudiante/app/caseUse/createStudent.caseUse";
import { CaseUseDeleteStudent } from "../../estudiante/app/caseUse/deleteStudent.caseUse";
import { CaseUseEditStudent } from "../../estudiante/app/caseUse/editStudent.caseUse";
import { CaseUseGetAllStudent } from "../../estudiante/app/caseUse/getAllStudent.caseUse";
import { CaseUseGetOneByIdStudent } from "../../estudiante/app/caseUse/getOnebyIdStudent.caseUse";
import { RepositoryInMemoryStudent } from "../../estudiante/infrastructure/test/repository/repositoryInMemoryStudent.repository";

const repo=new RepositoryInMemoryStudent()

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
