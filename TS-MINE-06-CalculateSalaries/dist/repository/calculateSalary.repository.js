"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.CalculateSalary = void 0;
const worker_model_1 = require("../model/worker.model");
class CalculateSalary {
    constructor() {
        this.workerModel = new worker_model_1.WorkerModel('\0', 0);
    }
    repositoryWork() {
        this.workerModel.work = 'Respository'.toLowerCase();
        this.workerModel.salary = 15890;
        const bonus = this.workerModel.salary * 0.1;
        const salary = bonus + this.workerModel.salary;
        console.log(`It works - Work: ${this.workerModel.work} - Salary: ${salary}`);
        return salary;
    }
    atmWork() {
        this.workerModel.work = 'ATM'.toLowerCase();
        this.workerModel.salary = 25630.89;
        console.log(`It works - Work: ${this.workerModel.work} - Salary: ${this.workerModel.salary}`);
        return this.workerModel.salary;
    }
    supervisorWork() {
        this.workerModel.work = 'Supervisor'.toLowerCase();
        this.workerModel.salary = 35560.2;
        const discount = this.workerModel.salary * 0.11;
        const salary = discount - this.workerModel.salary;
        console.log(`It works - Work: ${this.workerModel.work} - Salary: ${salary}`);
        return salary;
    }
}
exports.CalculateSalary = CalculateSalary;
//# sourceMappingURL=calculateSalary.repository.js.map