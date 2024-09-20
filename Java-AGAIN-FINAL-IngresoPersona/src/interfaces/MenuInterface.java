package interfaces;

public class MenuInterface {
    public void introduction(){ //! INTRODUCTION
        System.out.println("\n"+"=".repeat(40)+"\n");
        System.out.println("¡¡¡ WELCOME TO PERSON ENTRY !!!");
        System.out.println("\n"+"=".repeat(40)+"\n");
    }
    
    public void mainMenu(){ //! MAIN MENU
        System.out.println("\n"+"=".repeat(20)+" MAIN MENU "+"=".repeat(20));
        System.out.println("1. INPUT.");
        System.out.println("2. OUTPUT.");
        System.out.println("3. EXIT.");
        System.out.println("\n"+"=".repeat(50)+"\n");
    }
    
    public void inputMenu(){ //! INPUT MENU
        System.out.println("\n"+"=".repeat(20)+" INPUT MENU "+"=".repeat(20));
        System.out.println("1. ADD A PERSON.");
        System.out.println("2. EDIT A PERSON.");
        System.out.println("3. DELETE A PERSON BY IC.");
        System.out.println("4. DELETE ALL PERSON.");
        System.out.println("5. GO BACK.");
        System.out.println("\n"+"=".repeat(50)+"\n");

    }

    public void outputMenu(){ //! OUTPUT MENU
        System.out.println("\n"+"=".repeat(20)+" OUTPUT MENU "+"=".repeat(20));
        System.out.println("1. VIEW LIST.");
        System.out.println("2. VIEW PERSON'S NAMES.");
        System.out.println("3. VIEW PERSON'S EMAILS.");
        System.out.println("4. VIEW PERSON'S IC.");
        System.out.println("5. GO BACK.");
        System.out.println("\n"+"=".repeat(50)+"\n");

    }
}
