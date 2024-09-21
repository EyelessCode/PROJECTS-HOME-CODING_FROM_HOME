package repository;

import java.util.Scanner;

import interfaces.MenuInterface;

public class OptionRepository {
    private MenuInterface mi=new MenuInterface();

    Scanner scanner=new Scanner(System.in);

    //? OPTIONS ---------------------------------------
    public int mainMenuOption(){ //! MAIN MENU OPTION
        int option=-1;

        while (option<1||option>3) {
            System.out.print("\n"+"|"+"-".repeat(5)+">: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINPUT ERROR. TRY TO PUT A VALIDED INPUT...\n"
                +"=".repeat(50)+"\n");
                mi.mainMenu();
                scanner.nextLine();
                System.out.print("\n"+"|"+"-".repeat(5)+">: ");
            }
            
            option=scanner.nextInt();
            if (option<1||option>3) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINVALIDED NUMBER. TRY TO PUT A NUMBER BETWEEN 1 AND 3...\n"
                +"=".repeat(50)+"\n");
                scanner.nextLine();
                mi.mainMenu();
            }

        }
        return option;
    }

    public int inputMenuOption(){ //!INPUT MENU OPTION
        int option=-1;

        while (option<1||option>4) {
            System.out.print("\n"+"|"+"-".repeat(5)+">: ");

            while (!scanner.hasNextInt()) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINPUT ERROR. TRY TO PUT A VALIDED INPUT...\n"
                +"=".repeat(50)+"\n");
                mi.inputMenu();
                scanner.nextLine();
                System.out.print("\n"+"|"+"-".repeat(5)+">: ");
            }
            
            option=scanner.nextInt();
            if (option<1||option>4) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINVALIDED NUMBER. TRY TO PUT A NUMBER BETWEEN 1 AND 4...\n"
                +"=".repeat(50)+"\n");
                scanner.nextLine();
                mi.inputMenu();
            }

        }
        return option;
    }

    public int adminMenuOption(){ //! ADMIN MENU OPTION
        int option=-1;

        while (option<1||option>4) {
            System.out.print("\n"+"|"+"-".repeat(5)+">: ");

            while (!scanner.hasNextInt()) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINPUT ERROR. TRY TO PUT A VALIDED INPUT...\n"
                +"=".repeat(50)+"\n");
                mi.adminMenu();
                scanner.nextLine();
                System.out.print("\n"+"|"+"-".repeat(5)+">: ");
            }
            
            option=scanner.nextInt();
            if (option<1||option>4) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINVALIDED NUMBER. TRY TO PUT A NUMBER BETWEEN 1 AND 4...\n"
                +"=".repeat(50)+"\n");
                scanner.nextLine();
                mi.adminMenu();
            }

        }
        return option;
    }

    //? OPTIONS INSIDE ON IT ------------------------------
    // ADMIN
    public int adminChangeMenuOption(){ //! ADMIN CHANGE MENU OPTION
        int option=-1;

        while (option<1||option>4) {
            System.out.print("\n"+"|"+"-".repeat(5)+">: ");

            while (!scanner.hasNextInt()) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINPUT ERROR. TRY TO PUT A VALIDED INPUT...\n"
                +"=".repeat(50)+"\n");
                mi.changeMenu();
                scanner.nextLine();
                System.out.print("\n"+"|"+"-".repeat(5)+">: ");
            }
            
            option=scanner.nextInt();
            if (option<1||option>4) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINVALIDED NUMBER. TRY TO PUT A NUMBER BETWEEN 1 AND 4...\n"
                +"=".repeat(50)+"\n");
                scanner.nextLine();
                mi.changeMenu();
            }

        }
        return option;
    }

    // ADMIN
    public int adminDeleteMenuOption(){ //! ADMIN DELETE MENU OPTION
        int option=-1;

        while (option<1||option>4) {
            System.out.print("\n"+"|"+"-".repeat(5)+">: ");

            while (!scanner.hasNextInt()) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINPUT ERROR. TRY TO PUT A VALIDED INPUT...\n"
                +"=".repeat(50)+"\n");
                mi.deleteMenu();
                scanner.nextLine();
                System.out.print("\n"+"|"+"-".repeat(5)+">: ");
            }
            
            option=scanner.nextInt();
            if (option<1||option>4) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINVALIDED NUMBER. TRY TO PUT A NUMBER BETWEEN 1 AND 4...\n"
                +"=".repeat(50)+"\n");
                scanner.nextLine();
                mi.deleteMenu();
            }

        }
        return option;
    }

    // ADMIN
    public int adminVisualizationMenuOption(){ //! ADMIN VISUALIZATION MENU OPTION
        int option=-1;

        while (option<1||option>5) {
            System.out.print("\n"+"|"+"-".repeat(5)+">: ");

            while (!scanner.hasNextInt()) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINPUT ERROR. TRY TO PUT A VALIDED INPUT...\n"
                +"=".repeat(50)+"\n");
                mi.visualizationMenu();
                scanner.nextLine();
                System.out.print("\n"+"|"+"-".repeat(5)+">: ");
            }
            
            option=scanner.nextInt();
            if (option<1||option>5) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINVALIDED NUMBER. TRY TO PUT A NUMBER BETWEEN 1 AND 5...\n"
                +"=".repeat(50)+"\n");
                scanner.nextLine();
                mi.visualizationMenu();
            }

        }
        return option;
    }

    // INPUT
    public int inputSignInMenuOption(){ //! INPUT SIGN IN MENU OPTION
        int option=-1;

        while (option!=1) {
            System.out.print("\n"+"|"+"-".repeat(5)+">: ");

            while (!scanner.hasNextInt()) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINPUT ERROR. TRY TO PUT A VALIDED INPUT...\n"
                +"=".repeat(50)+"\n");
                mi.signInMenu();
                scanner.nextLine();
                System.out.print("\n"+"|"+"-".repeat(5)+">: ");
            }
            
            option=scanner.nextInt();
            if (option!=1) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINVALIDED NUMBER. TRY TO PUT THE NUMBER 1...\n"
                +"=".repeat(50)+"\n");
                scanner.nextLine();
                mi.signInMenu();
            }

        }
        return option;
    }

    //? SWITCHES -----------------------------------------
    public void switchesMainMenu(){ //! SWITCHES MAIN MENU
        boolean door=true;
        while (door) {
            mi.introduction();
            mi.mainMenu();
            int option=mainMenuOption();
            switch (option) {
                case 1: // OPTIONS INPUT...
                    System.out.println("GETTING TO THE INPUT OPTION...");
                    switchesInputMenu();
                    break;
                case 2: // OPTIONS ADMIN...
                    System.out.println("GETTING TO THE ADMIN OPTION...");
                    switchesAdminMenu();
                    break;
                case 3: // OPTION EXIT...
                    System.out.println("LEAVING...");
                    mi.endput();
                    door=false;
                    break;
                default: // I DON'T KNOW WHAT IS THIS...
                    System.out.println("\n¿LETTER OR NUMBER?\n");
                    break;
            }
        }
    }

    public void switchesInputMenu(){ //! SWITCHES INPUT MENU
        boolean door=true;
        while (door) {
            mi.inputMenu();
            int option=inputMenuOption();
            switch (option) {
                case 1: // OPTION SIGN IN...
                    System.out.println("GETTING TO THE SIGN IN OPTION...");
                    switchesInputSignInMenu();
                    break;
                case 2: // OPTION SIGN UP...
                    System.out.println("GETTING TO THE SIGN UP OPTION...");
                    System.out.println("WORKING YET...");
                    break;
                case 3: // OPTION DELETE THE REGISTRATION...
                    System.out.println("GETTING TO THE DELETING THE REGISTRATION OPTION...");
                    System.out.println("WOKRING YET...");
                    break;
                case 4: // OPTION GO BACK...
                    return;
                default: // I DON'T KNOW WHAT IS THIS...
                    System.out.println("\n¿LETTER OR NUMBER?\n");
                    break;
            }
            
        }
    }

    public void switchesAdminMenu(){ //! SWITCHES ADMIN MENU
        boolean door=true;
        while (door) {
            mi.adminMenu();
            int option=adminMenuOption();
            switch (option) {
                case 1: // OPTION CHANGE SECTION...
                    System.out.println("GETTING TO THE CHANGE SECTION...");
                    System.out.println("WORKING YET...");
                    switchesAdminChangeMenu();
                    break;
                case 2: // OPTION DELETE SECTION...
                    System.out.println("GETTING TO THE DELETE SECTION OPTION...");
                    switchesAdminDeleteMenu();
                    break;
                case 3: // OPTION VISUALIZATION SECTION...
                    System.out.println("GETTING TO THE VISUALIZATION SECTION OPTION...");
                    switchesAdmindVisualizationMenu();
                    break;
                case 4: // OPTION GO BACK...
                    door=false;
                    return;
                default: // I DON'T KNOW WHAT IS THIS...
                    System.out.println("\n¿LETTER OR NUMBER?\n");
                    break;
            }
            
        }
    }

    // ADMIN
    public void switchesAdminChangeMenu(){ //! SWITCHES ADMIN CHANGE MENU
        boolean door=true;
        while (door) {
            mi.changeMenu();
            int option=adminChangeMenuOption();
            switch (option) {
                case 1: // OPTION ADD A PERSON...
                    System.out.println("GETTING TO THE ADDING A PERSON...");
                    System.out.println("WORKING YET...");
                    break;
                case 2: // OPTION ADD AN ADMIN...
                    System.out.println("GETTING TO THE DELETE SECTION OPTION...");
                    System.out.println("WORKING YET...");
                    break;
                case 3: // OPTION EDIT A PERSON BY SEARCH...
                    System.out.println("GETTING TO THE VISUALIZATION SECTION OPTION...");
                    System.out.println("WORKING YET...");
                    break;
                case 4: // OPTION GO BACK...
                    return;
                default: // I DON'T KNOW WHAT IS THIS...
                    System.out.println("\n¿LETTER OR NUMBER?\n");
                    break;
            }
            
        }
    }
    
    // ADMIN
    public void switchesAdminDeleteMenu(){ //! SWITCHES ADMIN DELETE MENU
        boolean door=true;
        while (door) {
            mi.deleteMenu();
            int option=adminDeleteMenuOption();
            switch (option) {
                case 1: // OPTION DELETE A PERSON BY SEARCH...
                    System.out.println("GETTING TO THE DELETE A PERSON BY SEARCH OPTION...");
                    System.out.println("WORKING YET...");
                    break;
                case 2: // OPTION DELETE YOUR ADMIN REGISTRATION...
                    System.out.println("GETTING TO THE DELETE YOUR ADMIN REGISTRATION OPTION...");
                    System.out.println("WORKING YET...");
                    break;
                case 3: // OPTION CLEAN LIST...
                    System.out.println("GETTING TO THE CLEAN LIST OPTION...");
                    System.out.println("WORKING YET...");
                    break;
                case 4: // OPTION GO BACK...
                    return;
                default: // I DON'T KNOW WHAT IS THIS...
                    System.out.println("\n¿LETTER OR NUMBER?\n");
                    break;
            }
            
        }
    }

    // ADMIN
    public void switchesAdmindVisualizationMenu(){ //! SWITCHES ADMIN VISUALIZATION MENU
        boolean door=true;
        while (door) {
            mi.visualizationMenu();
            int option=adminVisualizationMenuOption();
            switch (option) {
                case 1: // OPTION VIEW LIST OPTION...
                    System.out.println("GETTING TO VIEW LIST OPTION...");
                    System.out.println("WORKING YET...");
                    break;
                case 2: // OPTION VIEW PERSON'S NAMES OPTION...
                    System.out.println("GETTING TO THE VIEW PERSON'S NAMES OPTION...");
                    System.out.println("WORKING YET...");
                    break;
                case 3: // OPTION VIEW PERSON'S EMAILS...
                    System.out.println("GETTING TO THE VIEW PERSON'S EMAILS...");
                    System.out.println("WORKING YET...");
                    break;
                case 4: // OPTION VIEW PERSON'S IC...
                    System.out.println("GETTING TO THE VIEW PERSON'S IC...");
                    System.out.println("WORKING YET...");
                    break;
                case 5: // OPTION GO BACK...
                    return;
                default: // I DON'T KNOW WHAT IS THIS...
                    System.out.println("\n¿LETTER OR NUMBER?\n");
                    break;
            }
            
        }
    }

    // INPUT
    public void switchesInputSignInMenu(){ //! SWITCHES ADMIN VISUALIZATION MENU
        boolean door=true;
        while (door) {
            mi.signInMenu();
            int option=inputSignInMenuOption();
            switch (option) {
                case 1: // OPTION GO BACK...
                    door=false;
                    return;
                default: // I DON'T KNOW WHAT IS THIS...
                    System.out.println("\n¿LETTER OR NUMBER?\n");
                    break;
            }
            
        }
    }
}
