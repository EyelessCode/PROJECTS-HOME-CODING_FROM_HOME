package view;

public class WorkerView {
    public void pickWorker(){
        lineString();
        System.out.println("1. REPOSITORY");
        System.out.println("2. ATM");
        System.out.println("3. SUPERVISOR");
        lineString();
    }

    public String lineString(){
        String LINE="=".repeat(30);
        return LINE;
    }
}
