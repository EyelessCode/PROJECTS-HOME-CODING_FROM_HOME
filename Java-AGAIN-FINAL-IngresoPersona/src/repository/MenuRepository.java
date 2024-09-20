package repository;

import java.util.Scanner;

import interfaces.MenuInterface;

public class MenuRepository {
    private MenuInterface mi=new MenuInterface();

    Scanner scanner=new Scanner(System.in);

    public int mainMenuOption(){ //! MAIN MENU OPTION
        int option=-1;

        while (option<1&&option>3) {
            System.out.print("\n"+"|"+"-".repeat(5)+">: ");

            while (!scanner.hasNextInt()) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINPUT ERROR. TRY TO PUT A VALIDED INPUT...\n"
                +"=".repeat(50)+"\n");
                scanner.nextLine();
            }
            
            option=scanner.nextInt();
            if (option<1||option>3) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINVALIDED NUMBER. TRY TO PUT A NUMBER BETWEEN 1 AND 3...\n"
                +"=".repeat(50)+"\n");
            }

        }
        return option;
    }

    public int inputMenuOption(){ //!INPUT MENU OPTION
        int option=-1;

        while (option<1&&option>4) {
            System.out.print("\n"+"|"+"-".repeat(5)+">: ");

            while (!scanner.hasNextInt()) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINPUT ERROR. TRY TO PUT A VALIDED INPUT...\n"
                +"=".repeat(50)+"\n");
                scanner.nextLine();
            }
            
            option=scanner.nextInt();
            if (option<1||option>4) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINVALIDED NUMBER. TRY TO PUT A NUMBER BETWEEN 1 AND 4...\n"
                +"=".repeat(50)+"\n");
            }

        }
        return option;
    }

    public int adminMenuOption(){ //! ADMIN MENU OPTION
        int option=-1;

        while (option<1&&option>4) {
            System.out.print("\n"+"|"+"-".repeat(5)+">: ");

            while (!scanner.hasNextInt()) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINPUT ERROR. TRY TO PUT A VALIDED INPUT...\n"
                +"=".repeat(50)+"\n");
                scanner.nextLine();
            }
            
            option=scanner.nextInt();
            if (option<1||option>4) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINVALIDED NUMBER. TRY TO PUT A NUMBER BETWEEN 1 AND 4...\n"
                +"=".repeat(50)+"\n");
            }

        }
        return option;
    }

    //? ADMIN
    public int adminChangeMenuOption(){ //! ADMIN CHANGE MENU OPTION
        int option=-1;

        while (option<1&&option>4) {
            System.out.print("\n"+"|"+"-".repeat(5)+">: ");

            while (!scanner.hasNextInt()) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINPUT ERROR. TRY TO PUT A VALIDED INPUT...\n"
                +"=".repeat(50)+"\n");
                scanner.nextLine();
            }
            
            option=scanner.nextInt();
            if (option<1||option>4) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINVALIDED NUMBER. TRY TO PUT A NUMBER BETWEEN 1 AND 4...\n"
                +"=".repeat(50)+"\n");
            }

        }
        return option;
    }

    //? ADMIN
    public int adminDeleteMenuOption(){ //! ADMIN DELETE MENU OPTION
        int option=-1;

        while (option<1&&option>4) {
            System.out.print("\n"+"|"+"-".repeat(5)+">: ");

            while (!scanner.hasNextInt()) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINPUT ERROR. TRY TO PUT A VALIDED INPUT...\n"
                +"=".repeat(50)+"\n");
                scanner.nextLine();
            }
            
            option=scanner.nextInt();
            if (option<1||option>4) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINVALIDED NUMBER. TRY TO PUT A NUMBER BETWEEN 1 AND 4...\n"
                +"=".repeat(50)+"\n");
            }

        }
        return option;
    }

    //? ADMIN
    public int adminVisualizationMenuOption(){ //! ADMIN VISUALIZATION MENU OPTION
        int option=-1;

        while (option<1&&option>5) {
            System.out.print("\n"+"|"+"-".repeat(5)+">: ");

            while (!scanner.hasNextInt()) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINPUT ERROR. TRY TO PUT A VALIDED INPUT...\n"
                +"=".repeat(50)+"\n");
                scanner.nextLine();
            }
            
            option=scanner.nextInt();
            if (option<1||option>5) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINVALIDED NUMBER. TRY TO PUT A NUMBER BETWEEN 1 AND 5...\n"
                +"=".repeat(50)+"\n");
            }

        }
        return option;
    }

    //? INPUT
    public int inputSignInMenuOption(){ //! INPUT SIGN IN MENU OPTION
        int option=-1;

        while (option!=1) {
            System.out.print("\n"+"|"+"-".repeat(5)+">: ");

            while (!scanner.hasNextInt()) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINPUT ERROR. TRY TO PUT A VALIDED INPUT...\n"
                +"=".repeat(50)+"\n");
                scanner.nextLine();
            }
            
            option=scanner.nextInt();
            if (option==1) {
                System.out.println("\n"+"=".repeat(50)
                +"\nINVALIDED NUMBER. TRY TO PUT THE NUMBER 1...\n"
                +"=".repeat(50)+"\n");
            }

        }
        return option;
    }
}
