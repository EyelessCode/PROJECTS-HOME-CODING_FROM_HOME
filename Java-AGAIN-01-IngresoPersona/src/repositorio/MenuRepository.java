package repositorio;

import java.util.Scanner;

import entidades.Person;

public class MenuRepository {
    private Person p;
    private Scanner scanner = new Scanner(System.in);
    private PersonRepository pr = new PersonRepository();
    private boolean door = true;

    public void menu() {
        System.out.println("\n" + "=".repeat(35) + "MAIN MENU" + "=".repeat(35));
        System.out.println("1. INPUT");
        System.out.println("2. OUTPUT");
        System.out.println("3. EXIT");
        System.out.println("=".repeat(80));
    }

    public void miniMenuInput() {
        System.out.println("\n" + "=".repeat(25) + "MINI-MENU OF INPUT" + "=".repeat(25));
        System.out.println("1. ADD A PERSON");
        System.out.println("2. EDIT A PERSON");
        System.out.println("3. DELETE ALL PERSON");
        System.out.println("4. DELETE PERSON BY IC");
        System.out.println("5. GO BACK");
        System.out.println("=".repeat(50));
    }

    public void miniMenuOutput() {
        System.out.println("\n" + "=".repeat(25) + "MINI-MENU OF OUTPUT" + "=".repeat(25));
        System.out.println("1. VIEW PERSON LIST");
        System.out.println("2. VIEW ONLY NAMES");
        System.out.println("3. VIEW ONLY IC");
        System.out.println("4. VIEW ONLY EMAILS");
        System.out.println("5. GO BACK");
        System.out.println("=".repeat(50));
    }

    public int optionMainMenu() {
        System.out.print("|" + "-".repeat(4) + " >: ");
        while (!scanner.hasNextInt()) {
            System.out.println("\n" + "=".repeat(35));
            System.out.println("ERROR OF FONT..." + "\nTRY AGAIN TO PUT A NUMBER NOT A LETTER...");
            System.out.println("=".repeat(35) + "\n\n\n");
            // switchesMain();
            // scanner.close();
            // break;
            scanner.nextLine();
            menu();
            System.out.print("|" + "-".repeat(4) + " >: ");
        }
        // scanner.nextLine();
        return scanner.nextInt();
    }

    // ! TESTING WITH A CONDITIONAL, NO WHILE

    // public int optionMainMenu() {
    // System.out.print("|" + "-".repeat(4) + " >: ");
    // if (scanner.hasNextInt()) {
    // switchesMain();
    // } else {
    // System.out.println("=".repeat(35));
    // System.out.println("ERROR OF FONT..." + "\nTRY AGAIN TO PUT A NUMBER NOT A
    // LETTER...");
    // System.out.println("=".repeat(35));
    // }
    // scanner.hasNextLine();
    // return scanner.nextInt();
    // }

    public int optionInputMenu() {
        System.out.print("|" + "-".repeat(4) + " >: ");
        while (!scanner.hasNextInt()) {
            System.out.println("\n" + "=".repeat(35));
            System.out.println("ERROR OF FONT..." + "\nTRY AGAIN TO PUT A NUMBER NOT A LETTER...");
            System.out.println("=".repeat(35) + "\n\n\n");
            scanner.nextLine();
            miniMenuInput();
            System.out.print("|" + "-".repeat(4) + " >: ");
        }
        return scanner.nextInt();
    }

    public int optionOutputMenu() {
        System.out.print("|" + "-".repeat(4) + " >: ");
        while (!scanner.hasNextInt()) {
            System.out.println("\n" + "=".repeat(35));
            System.out.println("ERROR OF FONT..." + "\nTRY AGAIN TO PUT A NUMBER NOT A LETTER...");
            System.out.println("=".repeat(35) + "\n\n\n");
            scanner.nextLine();
            miniMenuOutput();
            System.out.print("|" + "-".repeat(4) + " >: ");
        }
        return scanner.nextInt();
    }

    public void switchesMain() {
        while (door) {
            menu();
            int option = optionMainMenu();
            // if () {
            switch (option) {
                case 1:
                    switchInput();
                    break;
                case 2:
                    switchOutput();
                    break;
                case 3:
                    System.exit(0);
                    // break;
                default:
                    System.out.println("\n" + "=".repeat(20) + "\nINPUT INVALIDED\n" + "=".repeat(20)
                            + "\nTRY TO PUT A NUMBER\n" + "=".repeat(20) + "\n\n\n");
                    scanner.nextLine();
                    break;
            }

            // }
        }
    }

    // ! TRYING TO MAKE A SWITCH INDIRECT
    public void switchInput() {
        miniMenuInput();
        // while (door) {
        int option = optionInputMenu();
        switch (option) {
            case 1:
                p = new Person(null, null, '\0', 0, null, null, null, null, null, null);
                pr.inputPerson(p);
                // switchInput();
                break;
            case 2:
                System.out.println("=".repeat(15) + "\nWORKING YET...\n" + "=".repeat(15));
                // switchInput();
                break;
            case 3:
                p = new Person(null, null, '\0', 0, null, null, null, null, null, null);
                pr.removeAllPerson(p);
                // pr.removePerson();
                break;
            case 4:
                System.out.print("ENTER THE IC OF THE PERSON: ");
                String ic = scanner.next();
                pr.removePersonByIc(ic);
                break;
            case 5:
                return;
            // break;
            default:
                System.out.println("\n" + "=".repeat(20) + "\nINPUT INVALIDED\n" + "=".repeat(20)
                        + "\nTRY TO PUT A NUMBER\n" + "=".repeat(20) + "\n\n\n");
                scanner.nextLine();
                miniMenuInput();
                break;
        }

        // }
    }

    public void switchOutput() {
        miniMenuOutput();
        // while (door) {
        int option = optionOutputMenu();
        switch (option) {
            case 1:
                pr.showPerson();
                break;
            case 2:
                pr.showPersonName();
                break;
            case 3:
                pr.showPersonIc();
                break;
            case 4:
                pr.showPersonEmails();
                break;
            case 5:
                return;
            default:
                System.out.println("\n" + "=".repeat(20) + "\nINPUT INVALIDED\n" + "=".repeat(20)
                        + "\nTRY TO PUT A NUMBER\n" + "=".repeat(20) + "\n\n\n");
                scanner.nextLine();
                miniMenuOutput();
                break;
        }

        // }
    }
}
