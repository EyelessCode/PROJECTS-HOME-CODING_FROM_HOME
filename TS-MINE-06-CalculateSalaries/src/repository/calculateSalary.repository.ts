import { WorkerModel } from '../model/worker.model';
export class CalculateSalary {
    private workerModel = new WorkerModel('\0', 0);

    repositoryWork(): number {
        this.workerModel.work = 'Respository'.toLowerCase();
        this.workerModel.salary = 15_890;
        const bonus: number = this.workerModel.salary * 0.1
        const salary: number = bonus + this.workerModel.salary;
        // const bonus:number=0.1
        // const salaryWithBonus:number=salary*bonus;
        console.log(`It works - Work: ${this.workerModel.work} - Salary: ${salary}`);
        return salary;
    }
    atmWork(): number {
        this.workerModel.work = 'ATM'.toLowerCase();
        this.workerModel.salary = 25_630.89;
        // const IVA:number=this.workerModel.salary*0.1
        // const salary:number=IVA+this.workerModel.salary;
        // const bonus:number=0.1
        // const salaryWithBonus:number=salary*bonus;
        console.log(`It works - Work: ${this.workerModel.work} - Salary: ${this.workerModel.salary}`);
        return this.workerModel.salary;
    }
    supervisorWork(): number {
        this.workerModel.work = 'Supervisor'.toLowerCase();
        this.workerModel.salary = 35_560.20;
        const discount: number = this.workerModel.salary * 0.11
        const salary: number = discount - this.workerModel.salary;
        // const bonus:number=0.1
        // const salaryWithBonus:number=salary*bonus;
        console.log(`It works - Work: ${this.workerModel.work} - Salary: ${salary}`);
        return salary;
    }
}