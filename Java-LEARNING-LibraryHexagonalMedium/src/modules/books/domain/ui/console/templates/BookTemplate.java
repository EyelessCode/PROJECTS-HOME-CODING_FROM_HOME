package modules.books.domain.ui.console.templates;

import shared.ui.console.templates.GenericTemplates;

public abstract class BookTemplate extends GenericTemplates{
    @Override
    protected void menu() {
        System.out.println(
            // "\n"+":".repeat(7)+" ¡WELCOME! "+":".repeat(7)+
            "\n"+"=".repeat(5)+" BOOK MENU "+"=".repeat(5)+
            "\n1. View all books."+
            "\n2. View genders."+
            "\n3. Search book."+
            // "\n-- 3 Create user. --"+
            // "\n-- 4 Remove user. --"+
            "\n4 Go back."
        );
    }

    protected void adminBookMenu() {
        System.out.println(
            "\n"+"-".repeat(5)+" ADMIN MOD "+"-".repeat(5)+
            "\n"+"=".repeat(5)+" BOOK MENU "+"=".repeat(5)+
            "\n1. View all books."+
            "\n2. View genders."+
            "\n3. Search book."+
            "\n4. Create book."+
            "\n5. Modify book."+
            "\n6. Remove book."+
            "\n7. Go back."+
            "\n"+"-".repeat(5)+" YOU MUST BE CAREFUL WITH >ROOT PRIVILEGES< "+"-".repeat(5)

        );
    }

    /* @Override
    protected void searchMenu() {
        System.out.println(
            "\n"+"=".repeat(5)+" SEARCH OPTION "+"=".repeat(5)+
            "\n1. By only ID."+
            "\n2. By title, author or gender."+
            "\n3 Go back."
        );
    } */
}
