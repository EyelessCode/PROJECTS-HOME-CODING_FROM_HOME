package repository;

import java.util.Scanner;

import view.WorkerView;

public class ValidationRepository {
    private CalculateSalaryRepository calculateSalaryRepository = new CalculateSalaryRepository();
    private WorkerView workerView=new WorkerView();
    private Scanner scanner = new Scanner(System.in);

    public int validationInput(){
        // boolean door=false;
        int input = -1;
        while (input<1||input>3) {
            System.out.print("SELECT YOUR WORK: ");

            while (!scanner.hasNextInt()) {
                System.out.println("PLEASE INPUT A NUMBER!");
                workerView.pickWorker();
                scanner.nextLine();
                System.out.print("SELECT YOUR WORK: ");
            }
            
            input=scanner.nextInt();
            if(input<1||input>3){
                System.out.println("PLEASE INPUT A NUMBER BETWEEN 1 AND 3");
                workerView.pickWorker();
                scanner.nextLine();
            }
        }
            return input;
    }

    public void validationPick(){
        boolean door=true;
        int input = validationInput();

        // while (door) {
            switch (input) {
                case 1:
                    System.out.println(calculateSalaryRepository.repositoryWorker());
                    door=false;
                    break;
                case 2:
                    System.out.println(calculateSalaryRepository.atmWorker());
                    door=false;
                    break;
                case 3:
                    System.out.println(calculateSalaryRepository.supervisorWorker());
                    door=false;
                    break;
            }
            
        // }

    }
}
