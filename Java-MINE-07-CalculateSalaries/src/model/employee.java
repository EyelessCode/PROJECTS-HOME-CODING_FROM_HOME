package model;

public class Employee {
    private String work;
    private double salary;
    
    public Employee(String work, double salary) {
        this.work = work;
        this.salary = salary;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [work=" + work + ", salary=" + salary + "]";
    }

    

    
}
