package interfaces;

public class MenuInterface {
    public void introduction(){ //! INTRODUCTION
        System.out.println("\n"+"=".repeat(40)+"\n");
        System.out.println("¡¡¡ WELCOME TO PERSON ENTRY !!!");
        System.out.println("\n"+"=".repeat(40)+"\n");
    }
    
    public void endput(){ //! ENDPUT
        System.out.println("\n"+"=".repeat(10)+" THANK YOU FOR COMING TO US "+"=".repeat(10));
        System.out.println("¡¡¡ WE'RE WAITING FOR YOU THE NEXT TIME, SEE'YA !!!");
        System.out.println("\n"+"=".repeat(50)+"\n");
    }

    //? BIG SECTION
    public void mainMenu(){ //! MAIN MENU
        System.out.println("\n"+"=".repeat(20)+" MAIN MENU "+"=".repeat(20));
        System.out.println("1. INPUT.");
        System.out.println("2. ADMIN.");
        System.out.println("3. EXIT.");
        System.out.println("\n"+"=".repeat(50)+"\n");
    }
    
    public void inputMenu(){ //! INPUT MENU
        System.out.println("\n"+"=".repeat(20)+" INPUT MENU "+"=".repeat(20));
        System.out.println("1. SIGN IN");
        System.out.println("2. SIGN UP.");
        System.out.println("3. DELETE YOUR REGISTRATION.");
        System.out.println("4. GO BACK.");
        System.out.println("\n"+"=".repeat(50)+"\n");

    }

    public void adminMenu(){ //! ADMIN MENU
        System.out.println("\n"+"=".repeat(20)+" ADMIN MENU "+"=".repeat(20));
        System.out.println("1. CHANGE SECTION.");
        System.out.println("2. DELETE SECTION.");
        System.out.println("3. VISUALIZATION SECTION.");
        System.out.println("4. GO BACK.");
        System.out.println("\n"+"=".repeat(50)+"\n");
        
    }
    
    //? SMALL SECTION
    // ADMIN
    public void changeMenu(){ //! CHANGE MENU
        System.out.println("\n"+"=".repeat(20)+" CHANGE SECTION "+"=".repeat(20));
        System.out.println("1. ADD A PERSON.");
        System.out.println("2. ADD AN ADMIN.");
        System.out.println("3. EDIT A PERSON BY SEARCH.");
        System.out.println("4. GO BACK.");
        System.out.println("\n"+"=".repeat(50)+"\n");
    } 
    
    // ADMIN
    public void deleteMenu(){ //! DELETE MENU
        System.out.println("\n"+"=".repeat(20)+" DELETE SECTION "+"=".repeat(20));
        System.out.println("1. DELETE A PERSON BY SEARCH.");
        System.out.println("2. DELETE YOUR ADMIN REGISTRATION.");
        System.out.println("3. CLEAN LIST.");
        System.out.println("4. GO BACK.");
        System.out.println("\n"+"=".repeat(50)+"\n");
    } 
    
    // ADMIN
    public void visualizationMenu(){ //! VISUALIZATION MENU
        System.out.println("\n"+"=".repeat(20)+" VISUALIZATION SECTION "+"=".repeat(20));
        System.out.println("1. VIEW LIST.");
        System.out.println("2. VIEW PERSON'S NAMES.");
        System.out.println("3. VIEW PERSON'S EMAILS.");
        System.out.println("4. VIEW PERSON'S IC.");
        System.out.println("5. GO BACK.");
        System.out.println("\n"+"=".repeat(50)+"\n");
    } 
}
