export class WorkerModel {
    constructor(public work: string, public salary: number) {
        this.work = work;
        this.salary = salary;
    }

    toString(): string {
        return `Employee: ${this.work}, Salary: ${this.salary}`;
    }
}

/*     export interface WorkerModel{
        work: string;
        salary: number;
    } */
