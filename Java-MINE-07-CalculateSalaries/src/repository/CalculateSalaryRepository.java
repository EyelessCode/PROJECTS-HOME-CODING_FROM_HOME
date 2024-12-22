package repository;

import model.Employee;

public class CalculateSalaryRepository {
    private Employee employee=new Employee(null, 0.00);

    public double repositoryWorker(){
        employee.setWork("Repository".toLowerCase());
        employee.setSalary(15_890);
        double bonus=0.10;
        double iva=employee.getSalary()*bonus;
        return employee.getSalary()+iva;
        // return 0;
    }

    public double atmWorker(){
        employee.setWork("ATM".toLowerCase());
        employee.setSalary(25_630.89);
        // double bonus=0.10;
        // double iva=employee.getSalary()*bonus;
        return employee.getSalary();
        // return 0;
    }

    public double supervisorWorker(){
        employee.setWork("Supervisor".toLowerCase());
        employee.setSalary(35_560.20);
        double discount=0.11;
        double iva=employee.getSalary()*discount;
        return employee.getSalary()-iva;
        // return 0;
    }
}
