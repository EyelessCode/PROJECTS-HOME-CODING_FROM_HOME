package modules.loans.domain.ui.console.templates;

import shared.ui.console.templates.GenericTemplates;

public abstract  class BookLoanTemplate extends GenericTemplates {
    @Override
    protected void menu() {
        System.out.println(
                // "\n"+":".repeat(7)+" ¡WELCOME! "+":".repeat(7)+
                "\n"+"=".repeat(5)+" LOAN MENU "+"=".repeat(5)+
                        "\n1. View all loans."+
                        "\n2. Search loan."+
                        // "\n-- 3 Create user. --"+
                        // "\n-- 4 Remove user. --"+
                        "\n3. Go back."
        );
    }

    protected void adminLoanMenu(){
        System.out.println(
                // "\n"+":".repeat(7)+" ¡WELCOME! "+":".repeat(7)+
                "\n"+"=".repeat(5)+" ADMIN LOAN MENU "+"=".repeat(5)+
                        "\n1. View all loans."+
                        "\n2. Search loan (Fullname, IC, Title, Author, or ISBN)."+
                        "\n3. Create loan."+
                        "\n4. Remove loan (Fullname, IC, Title, Author, or ISBN)."+
                        "\n5. Go back."
        );
    }

    protected void submenu(){
        System.out.println(
                "\n"+"-".repeat(5)+" SUBMENU LOANS "+"-".repeat(5)+
                        "\n1. Get Loans by Date (Only date before return date)."+
                        "\n2. Get Loans."+
                        "\n3. Go back."
        );
    }
}
