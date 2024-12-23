package repository;

import java.util.Scanner;

import view.VectorView;

public class ValidationRepository {
    private Scanner scanner = new Scanner(System.in);
    private VectorView vectorView = new VectorView();

    public int inputvalidation(){
        int input = -1;
        
        while (!scanner.hasNextInt()) {
            System.out.println("Input a number not a word");
            System.out.print("→: ");
            vectorView.draw();
            scanner.next();
        }
        input=scanner.nextInt();
        return input;
    }
}
