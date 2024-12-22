package model;

public class Employee {
    private String work;
    private int salary;
    
    public Employee(String work, int salary) {
        this.work = work;
        this.salary = salary;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "employee [work=" + work + ", salary=" + salary + "]";
    }

    
}
