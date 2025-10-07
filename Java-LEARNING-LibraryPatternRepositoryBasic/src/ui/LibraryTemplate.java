package ui;

public abstract class LibraryTemplate {
    protected abstract byte validatorOption();
    protected abstract void mainOptions();
    protected abstract void bookOptions();
    protected abstract void userOptions();
    protected abstract void loanBookOptions();
    protected void mainMenu(){
        System.out.println
        (
            "\n"+"=".repeat(5)+" LIBRARY SYS "+"=".repeat(5)+
            "\n1. Book menu."+
            "\n2. User menu."+
            "\n3. Loan books menu."+
            "\n4. Exit."
        );
    }

    protected void bookMenu(){
        System.out.println
        (
            "\n"+"=".repeat(5)+" BOOK MENU "+"=".repeat(5)+
            "\n1. Check all books."+
            "\n2. Check all book availables."+
            "\n3. Find a book."+
            "\n4. Exit."
        );
    }

    protected void userMenu(){
        System.out.println
        (
            "\n"+"=".repeat(5)+" USER MENU "+"=".repeat(5)+
            "\n1. Check all users."+
            "\n2. Check an user."+
            "\n3. Exit."
        );
    }

    protected void loanBookMenu(){
        System.out.println
        (
            "\n"+"=".repeat(5)+" LOAN BOOKS "+"=".repeat(5)+
            "\n1. Make a loan book."+
            "\n2. Check all loan books."+
            "\n3. Check a loan book."+
            "\n4. Delete loan book."+
            "\n5. Exit."
        );
    }
}
