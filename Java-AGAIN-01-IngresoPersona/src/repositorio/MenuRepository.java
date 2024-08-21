package repositorio;

import java.util.Scanner;

public class MenuRepository {
    private Scanner scanner = new Scanner(System.in);
    private PersonRepository pr;
    private boolean door=true;

    public void menu() {
        System.out.println("=".repeat(35) + "MAIN MENU" + "=".repeat(35));
        System.out.println("1. INPUT");
        System.out.println("2. OUTPUT");
        System.out.println("3. EXIT");
        System.out.println("=".repeat(80));
    }

    public void miniMenuInput() {
        System.out.println("=".repeat(25) + "MINI-MENU OF INPUT" + "=".repeat(25));
        System.out.println("1. ADD A PERSON");
        System.out.println("2. EDIT A PERSON");
        System.out.println("3. DELETE A PERSON");
        System.out.println("4. GO BACK");
        System.out.println("=".repeat(50));
    }

    public void miniMenuOutput() {
        System.out.println("=".repeat(25) + "MINI-MENU OF OUTPUT" + "=".repeat(25));
        System.out.println("1. VIEW PERSON LIST");
        System.out.println("2. VIEW ONLY NAMES");
        System.out.println("3. VIEW ONLY IC");
        System.out.println("4. VIEW ONLY EMAILS");
        System.out.println("5. GO BACK");
        System.out.println("=".repeat(50));
    }
    
    public int optionMainMenu(){
        System.out.print("|"+"-".repeat(4)+" >: ");
        while (!scanner.hasNextInt()) {
            System.out.println("=".repeat(35));
            System.out.println("ERROR OF FONT..."+"\nTRY AGAIN TO PUT A NUMBER NOT A LETTER...");
            System.out.println("=".repeat(35));
        }
        return scanner.nextInt();
    }
    
    // public int optionInputMenu(){
    //     System.out.print("|"+"-".repeat(4)+" >: ");
    //     while (!scanner.hasNextInt()) {
    //         System.out.println("=".repeat(35));
    //         System.out.println("ERROR OF FONT..."+"\nTRY AGAIN TO PUT A NUMBER NOT A LETTER...");
    //         System.out.println("=".repeat(35));
    //     }
    //     return scanner.nextInt();
    // }

    // public int optionOutputMenu(){
    //     System.out.print("|"+"-".repeat(4)+" >: ");
    //     while (!scanner.hasNextInt()) {
    //         System.out.println("=".repeat(35));
    //         System.out.println("ERROR OF FONT..."+"\nTRY AGAIN TO PUT A NUMBER NOT A LETTER...");
    //         System.out.println("=".repeat(35));
    //     }
    //     return scanner.nextInt();
    // }

    public void switchesMain(){
        while (door) {
            menu();
            int option=optionMainMenu();
            switch (option) {
                case 1:
                    miniMenuInput();
                    switch (option) {
                        case 1:
                            pr.inputPerson();
                            break;
                    
                        default:
                            break;
                    }
                    break;
            
                default:
                    break;
            }
        }
    }
}
