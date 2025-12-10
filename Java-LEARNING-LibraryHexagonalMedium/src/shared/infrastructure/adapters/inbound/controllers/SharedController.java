package shared.infrastructure.adapters.inbound.controllers;

import modules.books.infrastructure.adapters.inbound.controllers.BookController;
import modules.loans.infrastructure.adapters.inbound.controllers.BookLoanController;
import modules.users.infrastructure.adapters.inbound.controllers.UserController;
import shared.ui.console.templates.GenericTemplates;

public class SharedController extends GenericTemplates {
    private final BookController bookController;
    private final UserController userController;
    private final BookLoanController loanController;

    public SharedController(){
        this.bookController=new BookController();
        this.userController=new UserController();
        this.loanController=new BookLoanController();
    }

    public void run(){
        mainOptions();
    }

    @Override
    protected void menu() {
        System.out.println(
                "\n"+"=".repeat(5)+" MAIN MENU "+"=".repeat(5)+
                "\n1. User menu."+
                "\n2. Book menu."+
                "\n3. Loan menu."+
                "\n4. Exit."
        );
    }

    private void mainOptions(){
        System.out.print(":".repeat(7)+" ¡WELCOME TO FreeLibrarySyS! "+":".repeat(7));
        String option;
        while (true) {
            menu();
            option=inCaseExit("Enter: ");
            switch (option) {
                case "1"->userController.userRun();
                case "2"->bookController.bookRun();
                case "3"->loanController.loanRun();
                case "root"->mainRootOptions();
                case "4"->{System.out.println("Exiting the Main Menu...");return;}
                default->System.out.println("Invalid option. Please enter a valid option (1-4).");
            }
        }
    }

    private void mainRootOptions(){
        String option;
        while (true) {
            System.out.print("\n"+"-".repeat(5)+" ADMIN MOD "+"-".repeat(5));
            menu();
            System.out.print("0. Leave root privileges.\n");
            option=inCaseExit("Enter: ");
            switch (option) {
                case "1"->bookController.bookRootRun();
                case "2"->userController.userRootRun();
                case "3"->loanController.loanRootRun();
                case "4"->{
                    System.out.println("Exiting the Main Menu...");System.exit(0);
                }
                case "0"->{System.out.println("Leaving root privileges...");return;}
                default->System.out.println("Invalid option. Please enter a valid option (0-4).");
            }
        }
    }
}
