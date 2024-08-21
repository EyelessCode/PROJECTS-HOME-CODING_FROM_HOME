package repositorio;

import java.util.Scanner;

public class MenuRepository {
    private Scanner scanner = new Scanner(System.in);

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
        System.out.print("ENTER A OPTION: ");
        int option=scanner.nextInt();
        while (!scanner.hasNextInt()) {
            System.out.println("=".repeat(35));
            System.out.println("ERROR..."+"\nTRY AGAIN...");
            System.out.println("=".repeat(35));
        }
        return option;
    }
    public int optionInputMenu(){
        System.out.print("ENTER A OPTION: ");
        int option=scanner.nextInt();
        while (!scanner.hasNextInt()) {
            System.out.println("=".repeat(35));
            System.out.println("ERROR OF FONT..."+"\nTRY AGAIN TO PUT A NUMBER NOT A LETTER...");
            System.out.println("=".repeat(35));
        }
        return option;
    }
    public int optionOutputMenu(){
        System.out.print("ENTER A OPTION: ");
        int option=scanner.nextInt();
        while (!scanner.hasNextInt()) {
            System.out.println("=".repeat(35));
            System.out.println("ERROR..."+"\nTRY AGAIN...");
            System.out.println("=".repeat(35));
        }
        return option;
    }
}
