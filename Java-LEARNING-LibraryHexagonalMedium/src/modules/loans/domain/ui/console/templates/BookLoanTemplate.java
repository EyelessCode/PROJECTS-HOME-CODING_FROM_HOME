package modules.loans.domain.ui.console.templates;

import shared.ui.console.templates.GenericTemplates;

public abstract  class BookLoanTemplate extends GenericTemplates {
    @Override
    protected void menu() {
        System.out.println(
                "\n"+"=".repeat(5)+" LOAN MENU "+"=".repeat(5)+
                "\n1. View all loans."+
                "\n2. Search loan."+
                "\n3. Go back."
        );
    }

    protected void adminLoanMenu(){
        System.out.println(
                "\n"+"-".repeat(5)+" ADMIN MOD "+"-".repeat(5)+
                "\n"+"=".repeat(5)+" LOAN MENU "+"=".repeat(5)+
                "\n1. View all loans."+
                "\n2. Search loan (date or any input)."+
                "\n3. Create loan."+
                "\n4. modify loan."+
                "\n5. Remove loan (IC or ISBN)."+
                "\n6. Go back."+
//                "\n0. Leave root privileges."+
                "\n"+"-".repeat(5)+" YOU MUST BE CAREFUL WITH >ROOT PRIVILEGES< "+"-".repeat(5)
        );
    }

    protected void submenu(){
        System.out.println(
                "\n"+"-".repeat(5)+" HOW TO SEARCH "+"-".repeat(5)+
                "\n1. Get Loans by Date (minor to return date)."+
                "\n2. Get Loans by anything (less dates)."+
                "\n3. Go back."
        );
    }
}
